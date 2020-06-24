package VladFedash;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myListCollection")
public class MyListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserList users = new UserList();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		try {
			writer.println("<head>\r\n" + 
					"<meta charset=\"utf-8\">\r\n" + 
					"<title>myList</title>\r\n" + 
					"<style>\r\n" + 
					"body {\r\n" + 
					"	margin-right: 40px; /* Отступ справа */\r\n" + 
					"	margin-left: 40px; /* Отступ слева */\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"table {\r\n" + 
					"	width: 100%;\r\n" + 
					"	\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"table, th, td {\r\n" + 
					"	border-collapse: collapse; /*убираем пустые промежутки между ячейками*/\r\n" + 
					"	border: 2px solid black;\r\n" + 
					"	border-collapse: collapse;\r\n" + 
					"	padding: 15px;\r\n" + 
					"}\r\n" + 
					"</style>\r\n" + 
					"</head>\r\n" + 
					"<body>           		\r\n" + 
					"            			<table>\r\n" + 
					"					        		<tr>\r\n" + 
					"					            				<th>Surname</th>\r\n" + 
					"					            					<th>Name</th>\r\n" + 
					"					            					<th>SecondName</th>\r\n" + 
					"					            					<th>Age</th>\r\n" + 
					"					            					<th>Height</th>\r\n" + 
					"					            				</tr>\r\n"); 
			 	users.init();
		        for (User o:users.getStudents()) {
		            
		        
						
						writer.print(
					"					            				<tr>\r\n" + 
					"					            					<td>"+o.getSurname()+"</td>\r\n" + 
					"					            					<td>"+o.getName()+"</td>\r\n" +
					"					            					<td>"+o.getSecondName()+"</td>\r\n" +
					"					            					<td>"+o.getAge()+"</td>\r\n" +
					"					            					<td>"+o.getHeight()+"</td>\r\n" +
					"					            				</tr>\r\n" ); 
		        }
		        writer.print("</table>  </body>\r\n");

		 }finally {
			writer.close();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.equals("admin") && password.equals("admin")) {
			response.sendRedirect(request.getContextPath()+"/myListCollection");
		} else {
			response.sendRedirect("index.html");
		}
	}

}
