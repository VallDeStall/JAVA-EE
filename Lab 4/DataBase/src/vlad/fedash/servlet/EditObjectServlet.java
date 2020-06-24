package vlad.fedash.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlad.fedash.Library;
import vlad.fedash.Reader;

@WebServlet("/editObject")
public class EditObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String authorOfBook = request.getParameter("authorOfBook");
		String titleOfBook = request.getParameter("titleOfBook");
		int yearOfEdition = Integer.parseInt(request.getParameter("yearOfEdition"));
		String fullName = request.getParameter("fullName");
		int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
		String phoneNumber = request.getParameter("phoneNumber");
		
		Reader reader = Library.selectOne(id);
		request.setAttribute("reader", reader);
		
		request.setAttribute("authorOfBook", authorOfBook);
		request.setAttribute("titleOfBook", titleOfBook);
		request.setAttribute("yearOfEdition", yearOfEdition);
		request.setAttribute("fullName", fullName);
		request.setAttribute("cardNumber", cardNumber);
		request.setAttribute("phoneNumber", phoneNumber);
		
		getServletContext().getRequestDispatcher("/editObject.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String author = request.getParameter("authorOfBook");
			String title = request.getParameter("titleOfBook");
			int yearOfEdit = Integer.parseInt(request.getParameter("yearOfEdition"));
			String fullName = request.getParameter("fullName");
			int card = Integer.parseInt(request.getParameter("cardNumber"));
			String phoneNumber = request.getParameter("phoneNumber");
			Reader reader = new Reader(id, author, title, yearOfEdit, fullName, card, phoneNumber);
			Library.update(reader);
			response.sendRedirect(request.getContextPath() + "/loadDatas");
		} catch (Exception ex) {

			getServletContext().getRequestDispatcher("/editObject.jsp").forward(request, response);
		}
	}

}
