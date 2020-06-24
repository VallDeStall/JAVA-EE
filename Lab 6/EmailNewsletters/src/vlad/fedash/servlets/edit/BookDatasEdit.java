package vlad.fedash.servlets.edit;

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

@WebServlet("/BookDatasEdit")
public class BookDatasEdit extends HttpServlet {
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

		getServletContext().getRequestDispatcher("/Edit/editBookDatas.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			SessionFactory sf = HibernateSessionFactoryUtil.getSessionFactory();
			ArrayList<BookDatas> book = new ArrayList<BookDatas>();
			ArrayList<Reader> reader = new ArrayList<Reader>();
			// entertainments=DB.reviewEntertainment(sf);
			// sights=DB.reviewSight(sf);
			// request.setAttribute("sights", sights);
			// request.setAttribute("entertainments", entertainments);
			int ind = Integer.parseInt(request.getParameter("index"));
			Reader read = DBActions.searchIndexReader(sf, ind);

			String authorOfBook = request.getParameter("authorOfBook");
			String titleOfBook = request.getParameter("titleOfBook");
			int yearOfEdition = Integer.parseInt(request.getParameter("yearOfEdition"));

			BookDatas bookDatas = new BookDatas(read, authorOfBook, titleOfBook, yearOfEdition);

			DBActions.editBookDatas(sf, bookDatas, Integer.parseInt(request.getParameter("id")));

			book = DBActions.reviewBookDatas(sf);
			request.setAttribute("book", book);
			reader = DBActions.reviewReader(sf);
			request.setAttribute("reader", reader);

			// SightDB.insert(sight);

			response.sendRedirect(request.getContextPath() + "/BookDatasIndex");
		} catch (Exception ex) {

			getServletContext().getRequestDispatcher("/Edit/editBookDatas.jsp").forward(request, response);

		}
	}
}
