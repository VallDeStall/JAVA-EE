package vlad.fedash.servlets.delete;

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

@WebServlet("/BookDatasDelete")
public class BookDatasDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		getServletContext().getRequestDispatcher("/Delete/deleteBookDatasMsg.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SessionFactory sf = HibernateSessionFactoryUtil.getSessionFactory();
			ArrayList<BookDatas> book = new ArrayList<BookDatas>();

			DBActions.deleteBookDatas(sf, Integer.parseInt(request.getParameter("id")));
			book = DBActions.reviewBookDatas(sf);
			request.setAttribute("book", book);

			response.sendRedirect(request.getContextPath() + "/BookDatasIndex");

		} catch (Exception ex) {
			getServletContext().getRequestDispatcher("/NotFound/bookDatasNotFound.jsp").forward(request, response);
		}

	}

}
