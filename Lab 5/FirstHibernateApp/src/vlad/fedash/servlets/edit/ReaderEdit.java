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
import vlad.fedash.entity.Reader;
import vlad.fedash.utils.HibernateSessionFactoryUtil;

@WebServlet("/ReaderEdit")
public class ReaderEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String fullName = request.getParameter("fullName");
		int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
		String phoneNumber = request.getParameter("phoneNumber");

		request.setAttribute("id", id);
		request.setAttribute("fullName", fullName);
		request.setAttribute("cardNumber", cardNumber);
		request.setAttribute("phoneNumber", phoneNumber);
		
		getServletContext().getRequestDispatcher("/Edit/editReader.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			SessionFactory sf = HibernateSessionFactoryUtil.getSessionFactory();
			ArrayList<Reader> reader = new ArrayList<Reader>();

			int id = Integer.parseInt(request.getParameter("id"));
			String fullName = request.getParameter("fullName");
			int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
			String phoneNumber = request.getParameter("phoneNumber");

			Reader read = new Reader(id, fullName, cardNumber, phoneNumber);
				DBActions.editReader(sf, read, id);
				reader = DBActions.reviewReader(sf);
				request.setAttribute("reader", reader);
				response.sendRedirect(request.getContextPath() + "/ReaderIndex");
			
		} catch (Exception ex) {

			getServletContext().getRequestDispatcher("/NotFound/ReaderNotFound.jsp").forward(request, response);
		}

	}
}
