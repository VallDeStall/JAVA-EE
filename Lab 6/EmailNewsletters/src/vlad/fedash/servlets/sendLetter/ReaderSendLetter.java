package vlad.fedash.servlets.sendLetter;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReaderSendLetter")
public class ReaderSendLetter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String username = "vladfedash2000@gmail.com";
		final String password = "Vlad123567Fedash";

		String email = request.getParameter("email");

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(request.getParameter("topic"));

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(request.getParameter("text"));

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();

			String fileName = "Readerlist.xml";
			String filePath = "D:\\Education\\3 Course\\2 Semestr\\Java EE\\Lab 6\\EmailNewsletters\\WebContent\\XMLFiles\\readerList.xml";

			DataSource source = new FileDataSource(filePath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileName);
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);
			Transport.send(message);

			response.setContentType("text/html;charset=UTF-8");
			request.getRequestDispatcher("/SendLet/send.jsp").forward(request, response);

		} catch (MessagingException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/NotFound/emailNotFound.jsp").forward(request, response);
		}

	}
}