package com.yfairy.test.startjetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class StartJettyWebFile {

	public static void main(String[] args) {
		try {
			Server server = new Server();
			Connector connector = new SelectChannelConnector();
			connector.setPort(8080);
			server.setConnectors(new Connector[] { connector });

			WebAppContext webAppContext = new WebAppContext();
			webAppContext.setContextPath("/");
			String ProPath = System.getProperty("user.dir");
			webAppContext.setResourceBase(ProPath + "\\src\\main\\webapp");
			webAppContext.setDescriptor(ProPath + "\\src\\main\\webapp\\WEB-INF\\web.xml");
			webAppContext.setWelcomeFiles(new String[] { "index.jsp" });
			webAppContext.setClassLoader(Thread.currentThread().getContextClassLoader());
			webAppContext.setConfigurationDiscovered(true);
			webAppContext.setParentLoaderPriority(true);
			server.setHandler(webAppContext);
			System.out.println("---------------------------------");
			System.out.println("ProPath:" + ProPath);
			System.out.println("ContextPath:" + webAppContext.getContextPath());
			System.out.println("Descriptor:" + webAppContext.getDescriptor());
			System.out.println("ResourceBase:" + webAppContext.getResourceBase());
			System.out.println("getWelcomeFiles:" + webAppContext.getWelcomeFiles().toString());
			System.out.println("---------------------------------");

			server.start();
			server.join();
			System.out.println("server is  start");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
