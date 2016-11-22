import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;


public class App {

  public static void main(String[] args) {

    ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
    servletContextHandler.setContextPath("/");

    ServletHolder servletHolder = servletContextHandler.addServlet(ServletContainer.class, "/*");
    servletHolder.setInitOrder(0);
    servletHolder.setInitParameter("jersey.config.server.provider.classnames", HelloWorldRest.class.getCanonicalName());

    Server server = new Server(8080);
    server.setHandler(servletContextHandler);

    try {
      server.start();
      server.join();
    } catch (Exception e) {
      System.out.println("Some exception occurred " + e);
    } finally {
      server.destroy();
    }
  }
}
