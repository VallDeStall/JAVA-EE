package vlad.fedash.servlets.XML;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import vlad.fedash.DB.DBActions;
import vlad.fedash.XMLWriter.BookDatasWriter;
import vlad.fedash.XMLWriter.ReaderWriter;
import vlad.fedash.entity.BookDatas;
import vlad.fedash.entity.Reader;
import vlad.fedash.utils.HibernateSessionFactoryUtil;

@WebServlet("/XML")
public class XML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String forReader = "C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps/EmailNewLetters//readerList.xml";
//		String forBookDatas = "C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps/EmailNewLetters//bookDatasList.xml";
		
		String forReader = "D:\\Education\\3 Course\\2 Semestr\\Java EE\\Lab 6\\EmailNewsletters\\WebContent\\XMLFiles\\readerList.xml";
		String forBookDatas = "D:\\Education\\3 Course\\2 Semestr\\Java EE\\Lab 6\\EmailNewsletters\\WebContent\\XMLFiles\\BookDatasList.xml";

		SessionFactory sf = HibernateSessionFactoryUtil.getSessionFactory();
		int choice = Integer.parseInt(request.getParameter("rb"));
		switch (choice) {
		case 1:
			ReaderWriter readerList = new ReaderWriter();
			ArrayList<Reader> reader = new ArrayList<Reader>();
			reader = DBActions.reviewReader(sf);
			for (int i = 0; i < reader.size(); i++) {
				readerList.addReader(reader.get(i));
			}

			readerList.WriteToXML(forReader);
			getServletContext().getRequestDispatcher("/ReaderSendLetter").forward(request, response);
			break;

		case 2:
			BookDatasWriter sportList = new BookDatasWriter();
			ArrayList<BookDatas> book = new ArrayList<BookDatas>();
			book = DBActions.reviewBookDatas(sf);
			for (int i = 0; i < book.size(); i++) {
				sportList.addBookDatas(book.get(i));
			}

			sportList.WriteToXML(forBookDatas);
			getServletContext().getRequestDispatcher("/BookDatasSendLetter").forward(request, response);
			break;
		default:
			getServletContext().getRequestDispatcher("/SendLetter").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
