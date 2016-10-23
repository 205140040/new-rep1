package com.yfairy.file.startfile;

import java.io.File;

import org.apache.jasper.servlet.JspServlet;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class StartWebFile {

	public static void main(String[] args) {
		try {
			String FILE_SEPARATOR = File.separator;

			Server server = new Server();

			Connector connector = new SelectChannelConnector();
			connector.setPort(8081);
			server.setConnectors(new Connector[] { connector });

			WebAppContext webAppContext = new WebAppContext();
			webAppContext.setContextPath("/");
			String ProjectPath = System.getProperty("user.dir");
			String webappPath = FILE_SEPARATOR + "src" + FILE_SEPARATOR + "main" + FILE_SEPARATOR + "webapp";
			String webXmlPath = webappPath + FILE_SEPARATOR + "WEB-INF" + FILE_SEPARATOR + "web.xml";
			webAppContext.setResourceBase(ProjectPath + webappPath);
			webAppContext.setDescriptor(ProjectPath + webXmlPath);
			webAppContext.setWelcomeFiles(new String[] { "index.jsp" });
			webAppContext.setClassLoader(Thread.currentThread().getContextClassLoader());
			webAppContext.setConfigurationDiscovered(true);
			webAppContext.setParentLoaderPriority(true);
			server.setHandler(webAppContext);
			
			System.out.println("---------------------------------");
			System.out.println("ProjectPath:" + ProjectPath);
			System.out.println("ContextPath:" + webAppContext.getContextPath());
			System.out.println("ResourceBase:" + webAppContext.getResourceBase());
			System.out.println("Descriptor:" + webAppContext.getDescriptor());
			System.out.println("---------------------------------");

			server.start();
			server.join();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
