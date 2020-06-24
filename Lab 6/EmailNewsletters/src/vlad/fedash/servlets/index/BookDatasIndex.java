package vlad.fedash.servlets.index;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import vlad.fedash.DB.DBActions;
import vlad.fedash.entity.BookDatas;
import vlad.fedash.entity.Reader;
import vlad.fedash.utils.HibernateSessionFactoryUtil;

@WebServlet("/BookDatasIndex")
public class BookDatasIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory sf = HibernateSessionFactoryUtil.getSessionFactory();
		ArrayList<BookDatas> book = new ArrayList<BookDatas>();
		ArrayList<Reader> reader = new ArrayList<Reader>();
		book = DBActions.reviewBookDatas(sf);
		reader = DBActions.reviewReader(sf);
		request.setAttribute("reader", reader);
		request.setAttribute("book", book);
		System.out.println(book);

		getServletContext().getRequestDispatcher("/Index/books.jsp").forward(request, response);

	}
}
