package vlad.fedash.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlad.fedash.FileOperations;
import vlad.fedash.KeyById;
import vlad.fedash.Library;

@WebServlet("/deleteObject")
public class DeleteObjectServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Library library;

	@Override
	public void init() throws ServletException {
		library = (Library) getServletContext().getAttribute("library");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookId = request.getParameter("id");
		Optional<KeyById> optionalBook = library.getBooksForKey().stream()
				.filter(b -> bookId.equals(String.valueOf(b.getId()))).findFirst();
		if (optionalBook.isPresent()) {
			KeyById keyById = optionalBook.get();
			library.deleteBook(keyById);
		}
		FileOperations.convertObjectToXml(library);

		
		getServletContext().getRequestDispatcher("/tableList.jsp").forward(request, response);
	}

}
