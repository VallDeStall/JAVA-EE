package vlad.fedash.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlad.fedash.Library;
import vlad.fedash.Reader;

@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name1 = request.getParameter("card");
		ArrayList<Reader> readers = Library.search(name1);
		request.setAttribute("readers", readers);
		if (readers.toString() == "[]") {
			getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/search.jsp").forward(request, response);
		}
	}

}
