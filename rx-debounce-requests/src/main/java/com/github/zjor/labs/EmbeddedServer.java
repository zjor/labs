package com.github.zjor.labs;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.Arrays;

@Slf4j
public class EmbeddedServer {

    private Server server;

    public EmbeddedServer(String contextPath, int port, Object... resources) {
        server = new Server(port);

        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setContextPath(contextPath);

        ResourceConfig rc = new ResourceConfig();
        Arrays.stream(resources).forEach(rc::register);

        ServletContainer servletContainer = new ServletContainer(rc);
        ServletHolder servletHolder = new ServletHolder(servletContainer);
        contextHandler.addServlet(servletHolder, "/*");

        server.setHandler(contextHandler);
    }

    public void start() throws Exception {
        server.start();
        log.info("Server started at {}", server.getURI());
    }

    public void stop() throws Exception {
        server.stop();
    }

    public void join() throws Exception {
        server.join();
    }

}