package vlad.fedash.servlets.utilities;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		
		boolean loggedIn = session != null && session.getAttribute("users") != null;
		boolean entern = request.getRequestURI().equals(request.getContextPath() + "/login");
		boolean notLog = request.getRequestURI().equals(request.getContextPath() + "/notAuth.jsp");
		boolean logId = request.getRequestURI().equals(request.getContextPath() + "/index.html");
		boolean enter = request.getRequestURI().equals(request.getContextPath() + "/");
		

		if (loggedIn || entern || notLog || logId || enter) {
			chain.doFilter(req, res);
		} else {
			request.getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}
}
