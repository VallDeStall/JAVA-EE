package vlad.fedash.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import vlad.fedash.KeyById;
import vlad.fedash.FileOperations;
import vlad.fedash.Library;
import vlad.fedash.Reader;

@WebServlet("/createNewObject")
public class NewObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Library library;

	@Override
	public void init() throws ServletException {
		library = (Library) getServletContext().getAttribute("library");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String author = request.getParameter("authorOfBook");
		String title = request.getParameter("titleOfBook");
		String yearOfEdit = request.getParameter("yearOfEdition");
		String fullName = request.getParameter("fullName");
		String card = request.getParameter("cardNumber");
		String phoneNumber = request.getParameter("phoneNumber");

		if (isEmtyString(author) || isEmtyString(author) || isEmtyString(author) || isEmtyString(author)
				|| isEmtyString(author)) {
			System.out.println("You aren't fill all datas");
			request.getRequestDispatcher("newObject.jsp").forward(request, response);

		} else {

			int yearOfEditNum = Integer.parseInt(yearOfEdit);
			int cardNum = Integer.parseInt(card);
			library.addBook(new KeyById(library.maxId()+1), new Reader(author, title, yearOfEditNum, fullName, cardNum, phoneNumber));
			FileOperations.convertObjectToXml(library);
			getServletContext().getRequestDispatcher("/tableList.jsp").forward(request, response);

		}
	}

	public boolean isEmtyString(String str) {

		return (str == null) || (str.trim().length() == 0);

	}
}
