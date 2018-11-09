package servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class FrequencyServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
	  	
		BufferedReader br = request.getReader();
		String line = br.readLine();
		List<String> words = new ArrayList<String>();
		HashMap<String, Integer> frequency = new HashMap<String, Integer>();
		
		while (line!=null) {
			line = cleansing(line);
			words.addAll(Arrays.asList(line.split(" ")));
			line = br.readLine();
		}
		
		for (String word : words) {
			if (!frequency.containsKey(word)) frequency.put(word,0);
			int count = frequency.get(word);
			frequency.put(word,count+1);
		}
		
		
		response.setContentType( "application/json" );
		response.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		String freqJson = gson.toJson(frequency);
	    PrintWriter pw = response.getWriter();
		pw.write(freqJson);
	    pw.close();
  }
	
	private String cleansing(String line) {
		String result = line.toLowerCase();
		result=line.replaceAll("[^a-zA-ZÀ-ÿ]", " ");
		return result;
	}

	public int genere(int min, int max) {
		return (int) Math.round(Math.random()*(max-min)+min);
	}

	private int parseEntier(String toParse, int defaut) {
		return toParse==null ? defaut : Integer.parseInt(toParse);
	}

}