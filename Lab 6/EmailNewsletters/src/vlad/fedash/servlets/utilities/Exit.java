package vlad.fedash.servlets.utilities;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Exit")
public class Exit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 public Exit() {
	        super();
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			session.invalidate();
			String login = "";
			String password = "";
			request.setAttribute("login", login);
			request.setAttribute("password", password);
			
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

}
