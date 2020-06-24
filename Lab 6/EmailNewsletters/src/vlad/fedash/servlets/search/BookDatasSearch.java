package vlad.fedash.servlets.search;

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
import vlad.fedash.utils.HibernateSessionFactoryUtil;

@WebServlet("/BookDatasSearch")
public class BookDatasSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SessionFactory sf = HibernateSessionFactoryUtil.getSessionFactory();
		String year = request.getParameter("year").trim();
		ArrayList<BookDatas> book = new ArrayList<BookDatas>();
		book = DBActions.searchBookDatas(sf, year);
		request.setAttribute("book", book);
		if (book.toString() == "[]") {
			getServletContext().getRequestDispatcher("/NotSearch/notSearchBookDatas.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/Search/searchBookDatas.jsp").forward(request, response);
		}
	}

}
