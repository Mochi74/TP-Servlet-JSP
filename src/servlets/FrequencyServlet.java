package servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrequencyServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
	  	
		BufferedReader br = request.getReader();
		String line = br.readLine();
		List<String> words = new ArrayList<String>();
		
		while (line!=null) {
			words.addAll(Arrays.asList(line.split(" ")));
			line = br.readLine();
		}
		
		
		response.setContentType( "text/html" );
	    PrintWriter out = response.getWriter();
	    out.println( "<HTML>" );
	    out.println( "<HEAD>");
	    out.println( "<TITLE>Page generee par une servlet</TITLE>" );
	    out.println( "</HEAD>" );
	    out.println( "<BODY>" );
	    out.println( ""+words.size() );
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