package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
	  	
		String[] tab = request.getRequestURL().toString().split("/");
		String lastElement = tab[tab.length-1];
		
		response.setContentType( "text/html" );
	    PrintWriter out = response.getWriter();
	    out.println( "<HTML>" );
	    out.println( "<HEAD>");
	    out.println( "<TITLE>Page generee par une servlet et quel servlet</TITLE>" );
	    out.println( "</HEAD>" );
	    out.println( "<BODY>" );
	    out.println( "<H1>Bonjour toi "+lastElement+"</H1>" );
	    out.println( "</BODY>" );
	    out.println( "</HTML>" );
	    out.close();
  }

}