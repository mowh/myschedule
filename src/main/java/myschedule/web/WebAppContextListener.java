package myschedule.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * WebAppContextListener
 *
 * @author Zemian Deng
 */
public class WebAppContextListener implements ServletContextListener {
	
	private static Logger logger = LoggerFactory.getLogger(WebAppContextListener.class);
	
	public static final String SPRING_DISPATCHER_URL_PREFIX = "/main";
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// Adding "contextPath" variable to all JSP pages.
		ServletContext ctx = sce.getServletContext();
		String contextPath = ctx.getContextPath();
		ctx.setAttribute("contextPath", contextPath);
		logger.info("Set attribute contextPath=" + ctx.getAttribute("contextPath"));
		
		ctx.setAttribute("actionPath", contextPath + SPRING_DISPATCHER_URL_PREFIX);
		logger.info("Set attribute actionPath=" + ctx.getAttribute("actionPath"));
		
		logger.info("Web application initialized.");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("Web application destroyed.");
	}

}
