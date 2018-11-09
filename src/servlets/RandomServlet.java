package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
	  	
		int min = parseEntier(request.getParameter("min").toString(),0);
		int max = parseEntier(request.getParameter("max").toString(),100);
		
		response.setContentType( "text/html" );
	    PrintWriter out = response.getWriter();
	    out.println( "<HTML>" );
	    out.println( "<HEAD>");
	    out.println( "<TITLE>Page generee par une servlet</TITLE>" );
	    out.println( "</HEAD>" );
	    out.println( "<BODY>" );
	    out.println( genere(min,max) );
	    out.println( "</BODY>" );
	    out.println( "</HTML>" );
	    out.close();
  }
	
	public int genere(int min, int max) {
		return (int) Math.round(Math.random()*(max-min)+min);
	}

	private int parseEntier(String toParse, int defaut) {
		return toParse==null ? defaut : Integer.parseInt(toParse);
	}

}