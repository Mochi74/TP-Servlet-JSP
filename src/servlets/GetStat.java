package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.StatDao;
import dao.TextDao;
import dao.WordDao;
import model.Distribution;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetStat
 */
public class GetStat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] tab = request.getRequestURL().toString().split("/");
		String lastElement = tab[tab.length-1];

		ArrayList<Distribution> obj = new ArrayList<Distribution>();
		
		
		switch(lastElement) {
			case "browser":
				obj = StatDao.getInstance().allByBrowser();
				break;
			case "country":
				obj = StatDao.getInstance().allByCountry();
				break;	
			case "day":
				obj = StatDao.getInstance().allByDay();
				break;
			default:
				return;
				
		}
		response.setContentType( "application/json" );
		response.setCharacterEncoding("UTF-8");
		
		Gson gson = new Gson();
		String freqJson = gson.toJson(obj);
	    PrintWriter pw = response.getWriter();
		pw.write(freqJson);
	    pw.close();

		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
