package servlets;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.RecordDao;
import dao.TextDao;
import dao.WordDao;
import model.Record;

	public class ReceiveStat extends HttpServlet {
		final Gson gson = new GsonBuilder().create();
	
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
			String texte = "";
			
			/* get all the Json input */
			BufferedReader br = request.getReader();
			String line = br.readLine();
			while (line!=null) {
				texte+=line;
				line = br.readLine();
				}
			
			/* store the Json in DataBase */ 
			Record record = gson.fromJson(texte,Record.class);
			
			/* store in database as it is */
			try( RecordDao recordDao = RecordDao.getInstance()){
				String textId = RecordDao.getInstance().save(record);				
				}
			
			response.setContentType( "text/plain" );
			response.setCharacterEncoding("UTF-8");
		    PrintWriter pw = response.getWriter();
		    pw.write(record.getDate()+" ");
		    pw.write(record.getIp()+" ");
		    pw.write(record.getPays()+" ");
		    pw.write(record.getBrowser()+" ");
		    pw.write(record.getVisitCount()+"\n");
		    
		    pw.close();
	  }
		

	}

