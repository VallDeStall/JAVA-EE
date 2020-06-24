package vlad.fedash.app.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import vlad.fedash.FileOperations;
import vlad.fedash.Library;

@WebListener
public class AppContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		Library library = new Library(FileOperations.readXmlFile());
		context.setAttribute("library", library);
	}

}
