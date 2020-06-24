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
import vlad.fedash.entity.Reader;
import vlad.fedash.utils.HibernateSessionFactoryUtil;

@WebServlet("/ReaderDelete")
public class ReaderDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		getServletContext().getRequestDispatcher("/Delete/deleteReaderMsg.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SessionFactory sf = HibernateSessionFactoryUtil.getSessionFactory();
			ArrayList<Reader> reader = new ArrayList<Reader>();

			DBActions.deleteReader(sf, Integer.parseInt(request.getParameter("id")));
			reader = DBActions.reviewReader(sf);
			request.setAttribute("reader", reader);

			response.sendRedirect(request.getContextPath() + "/ReaderIndex");

		} catch (Exception ex) {
			getServletContext().getRequestDispatcher("/NotFound/readerNotFound.jsp").forward(request, response);
		}

	}
}
