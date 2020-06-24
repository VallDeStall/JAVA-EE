package vlad.fedash.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlad.fedash.Library;
import vlad.fedash.Reader;

@WebServlet("/deleteObject")
public class DeleteObjectServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Reader reader = Library.selectOne(id);
		request.setAttribute("reader", reader);
		request.setAttribute("id", id);
		getServletContext().getRequestDispatcher("/deleteMsg.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hello!");
		int id = Integer.parseInt(request.getParameter("id"));
		Library.delete(id);
		 getServletContext().getRequestDispatcher("/loadDatas").forward(request, response);

	}

}
