package vlad.fedash.servlets.index;

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

@WebServlet("/ReaderIndex")
public class ReaderIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory sf = HibernateSessionFactoryUtil.getSessionFactory();
		ArrayList<Reader> reader = new ArrayList<Reader>();
		reader = DBActions.reviewReader(sf);
		request.setAttribute("reader", reader);

		getServletContext().getRequestDispatcher("/Index/readers.jsp").forward(request, response);
	}

}
