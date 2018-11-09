package servlets;

import java.io.*;
import javax.servlet.*;

public class FirstServlet implements Servlet {
  private ServletConfig cfg;

  public void init(ServletConfig config) throws ServletException {
     cfg = config;
     System.out.println("INITIALISATION");
  }

  public ServletConfig getServletConfig() {
    return cfg;
  }

  public String getServletInfo() {
    return "Une servlet de test";
  }	

  public void destroy() {
	  
  }
  

  public void service (ServletRequest req,  ServletResponse res ) 
  throws ServletException, IOException  {
    res.setContentType( "text/html" );
    PrintWriter out = res.getWriter();
    out.println( "<HTML>" );
    out.println( "<HEAD>");
    out.println( "<TITLE>Page generee par une servlet</TITLE>" );
    out.println( "</HEAD>" );
    out.println( "<BODY>" );
    out.println( "<H1>Bonjour</H1>" );
    out.println( "</BODY>" );
    out.println( "</HTML>" );
    out.close();
  }
}