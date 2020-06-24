package vlad.fedash.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlad.fedash.FileOperations;
import vlad.fedash.KeyById;
import vlad.fedash.Library;
import vlad.fedash.Reader;

@WebServlet("/editObject")
public class EditObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Library library;
	
	@Override
	public void init() throws ServletException {
		library = (Library) getServletContext().getAttribute("library");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bookId = request.getParameter("id");
		String author = request.getParameter("authorOfBook");
		String title = request.getParameter("titleOfBook");
		String yearOfEdit = request.getParameter("yearOfEdition");
		String fullName = request.getParameter("fullName");
		String card = request.getParameter("cardNumber");
		String phoneNumber = request.getParameter("phoneNumber");

		int yearOfEditNum = Integer.parseInt(yearOfEdit);
		int cardNum = Integer.parseInt(card);
		int parseBookId = Integer.parseInt(bookId);

		library.editBook(new KeyById(parseBookId),new Reader(author, title, yearOfEditNum, fullName, cardNum, phoneNumber));
		FileOperations.convertObjectToXml(library);

		getServletContext().getRequestDispatcher("/tableList.jsp").forward(request, response);

	}

}
