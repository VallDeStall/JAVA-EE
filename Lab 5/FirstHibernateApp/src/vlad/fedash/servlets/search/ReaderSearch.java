package vlad.fedash.servlets.search;

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

@WebServlet("/ReaderSearch")
public class ReaderSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		    	
		    	SessionFactory sf = HibernateSessionFactoryUtil.getSessionFactory();
		    	String cardNumber = request.getParameter("card").trim();
		        ArrayList<Reader> reader = new ArrayList<Reader>();
		        reader=DBActions.searchReader(sf,cardNumber);
		        request.setAttribute("reader", reader);
		        if(reader.toString()=="[]") {
		        	getServletContext().getRequestDispatcher("/NotSearch/notSearchReader.jsp").forward(request, response);
		          }
		        else {
			getServletContext().getRequestDispatcher("/Search/searchReader.jsp").forward(request, response);
		        }
		    }

}
