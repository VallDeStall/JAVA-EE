package vlad.fedash.servlets.utilities;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import vlad.fedash.DB.DBActions;
import vlad.fedash.entity.Users;
import vlad.fedash.utils.HibernateSessionFactoryUtil;

@WebServlet("/login")
public class CheckInputDatas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		SessionFactory sf = HibernateSessionFactoryUtil.getSessionFactory();
		String login = request.getParameter("username");
		String password = request.getParameter("password");

		if ((login == null) || (password == null)) {
			String path = request.getContextPath() + "/index.html";
			response.sendRedirect(path);
		}
		if (DBActions.userIsExist(sf, login, password) == true) {
			session.setMaxInactiveInterval(-1);
			Users users = new Users(login, password);
			session.setAttribute("users", users);
			session.setAttribute("login", login);
			String path = request.getContextPath() + "/main.jsp";
			response.sendRedirect(path);
		} else {
			request.getRequestDispatcher("/NotAuth/notAuth.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}