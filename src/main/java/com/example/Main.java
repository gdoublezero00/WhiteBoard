package com.example;

import java.net.URL;
import java.security.ProtectionDomain;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
	public static void main(String[] args) {
		String value = System.getProperty("port");
		System.out.println(value);

		int port = 9999;
		if (value != null) {
			port = Integer.parseInt(value);
		}

		value = System.getProperty("contextPath");
		
		String contextPath = "/";
		if (value != null) {
			contextPath = "/" + value;
		}
		Server server = new Server(port);

		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath(contextPath);
		ProtectionDomain protectionDomain = Main.class.getProtectionDomain();
		webapp.setWar(protectionDomain.getCodeSource().getLocation().toExternalForm());
		server.setHandler(webapp);

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
