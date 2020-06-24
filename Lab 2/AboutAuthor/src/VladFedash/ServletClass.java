package VladFedash;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aboutMe")
public class ServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		try {
			writer.println("<head>\r\n" + "<meta charset=\"utf-8\">\r\n" + "<title>About</title>\r\n" + "<style>\r\n"
					+ "body {\r\n" + "	margin-right: 40px; /* ќтступ справа */\r\n"
					+ "	margin-left: 40px; /* ќтступ слева */\r\n" + "}\r\n" + "\r\n" + "img {\r\n"
					+ "	margin-right: 40px; /* ќтступ справа */\r\n" + "}\r\n" + "\r\n" + "table {\r\n"
					+ "	width: 100%;\r\n" + "	\r\n" + "}\r\n" + "\r\n" + "table, th, td {\r\n"
					+ "	border-collapse: collapse; /*убираем пустые промежутки между €чейками*/\r\n"
					+ "	border: 2px solid black;\r\n" + "	border-collapse: collapse;\r\n" + "	padding: 15px;\r\n"
					+ "}\r\n" + "</style>\r\n" + "</head>\r\n" + "<body>\r\n"
					+ "	<b style=\"font-size: 20px;\">Contact information: \r\n" + "\r\n"
					+ "	<img src=\"myPhoto.jpg\" style=\"position: absolute; top: 0px; right: 0px\"\r\n"
					+ "		width=150 height=150>\r\n" + "\r\n" + "	<br>\r\n"
					+ "	<br> Fedash Vladislav Aleksandrovich\r\n" + "	<br> Age: 19 y.o.\r\n"
					+ "	<br> Phone: +380 (666) 333 515\r\n" + "	<br> Email: vladfedash2000@gmail.com\r\n"
					+ "	<br> Skype: live:8fee6b2e91f20f73</b>\r\n" + "	<br>\r\n" + "	<br>\r\n" + "	<br>\r\n"
					+ "	\r\n" + "\r\n" + "	<table>\r\n" + "		<tr>\r\n"
					+ "			<td>Summary of Qualifications</td>\r\n"
					+ "			<td>Novice Java Developer with basic knowledge of OOP and Java\r\n"
					+ "				EE.</td>\r\n" + "		</tr>\r\n" + "\r\n" + "		<tr>\r\n"
					+ "			<td>Skills</td>\r\n"
					+ "			<td>SQL, Java Core, , Servlet API, JDBC, JSP/JSTL</td>\r\n" + "		</tr>\r\n" + "\r\n"
					+ "		<tr>\r\n" + "			<td>Experience / IT related educational practice</td>\r\n"
					+ "			<td>-</td>\r\n" + "		</tr>\r\n" + "\r\n" + "		<tr>\r\n"
					+ "			<td>Languages</td>\r\n" + "			<td>ENGLISH(intermediate)</td>\r\n"
					+ "		</tr>\r\n" + "\r\n" + "		<tr>\r\n" + "			<td>Education</td>\r\n"
					+ "			<td>NTU УKHPIФ 2017-2022 Software Engineer</td>\r\n" + "		</tr>\r\n" + "\r\n"
					+ "		<tr>\r\n" + "			<td>Additional education (courses, trainings)</td>\r\n"
					+ "			<td>EPAM Ц Java external courses 08.2019-011.2020</td>\r\n" + "		</tr>\r\n" + "\r\n"
					+ "		<tr>\r\n" + "			<td>Hobbies</td>\r\n"
					+ "			<td>Sport(attend the gym and swimming pool), movies, listening\r\n"
					+ "				of music, books and etc.</td>\r\n" + "		</tr>\r\n" + "		\r\n"
					+ "	</table>\r\n 	<br>\r\n"
					+ "	<button onClick=\"location.href='index.html'\">Return to the main page</button>"
					+ "</body>\r\n");
		} finally {
			writer.close();
		}
	}

}
