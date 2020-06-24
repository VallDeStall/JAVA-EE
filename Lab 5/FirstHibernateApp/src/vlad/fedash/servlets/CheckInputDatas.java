package vlad.fedash.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class CheckInputDatas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckInputDatas() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("username");
		String password = request.getParameter("password");

		if (("admin").equals(login) && password.equals("admin")) {
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} else {
			PrintWriter pw = response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Invalid Username or Password');");
			pw.println("</script>");
			request.getRequestDispatcher("/index.html").forward(request, response);
		}

	}

//	private static Sight getSights(Node node) {
//		Sight ex = new Sight();
//		if (node.getNodeType() == Node.ELEMENT_NODE) {
//			Element element = (Element) node;
//			// ex.setNumber(getTagValue("number", element));
//			ex.setName(getTagValue("name", element));
//			ex.setCity(getTagValue("city", element));
//			ex.setDescription(getTagValue("description", element));
//		}
//
//		return ex;
//	}
//
//	private static String getTagValue(String tag, Element element) {
//
//		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
//		Node node = (Node) nodeList.item(0);
//		return node.getNodeValue();
//
//	}

}