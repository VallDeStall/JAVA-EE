package vlad.fedash.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlad.fedash.Library;
import vlad.fedash.Reader;

@WebServlet("/createNewObject")
public class NewObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		 
		        getServletContext().getRequestDispatcher("/newObject.jsp").forward(request, response);
		    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try {
			String author = request.getParameter("authorOfBook");
			String title = request.getParameter("titleOfBook");
			int yearOfEdit = Integer.parseInt(request.getParameter("yearOfEdition"));
			String fullName = request.getParameter("fullName");
			int card = Integer.parseInt(request.getParameter("cardNumber"));
			String phoneNumber = request.getParameter("phoneNumber");
			Reader reader = new Reader(author, title, yearOfEdit, fullName, card, phoneNumber);
			Library.insert(reader);
			getServletContext().getRequestDispatcher("/loadDatas").forward(request, response);
		} catch (Exception ex) {

			getServletContext().getRequestDispatcher("/newObject.jsp").forward(request, response);
		}
	}
}
