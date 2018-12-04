package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import model.Distribution;
import model.Record;
import model.Texte;


public class StatDao extends DaoConnection {
	
	private static StatDao SINGLETON = null;
	
	
	private StatDao() {
		
	}
	
	public static StatDao getInstance() {
		if (SINGLETON==null) 
			SINGLETON = new StatDao();
			
		if (SINGLETON.c==null) {
			SINGLETON.openConnection();	
		}
		return SINGLETON;
	}
	
	
/*	chart.data = [{
		  "country": "Lithuania",
		  "litres": 501.9
		}, {
		  "country": "Czech Republic",
		  "litres": 301.9
		}, {
		  "country": "Ireland",
		  "litres": 201.1
		}, {
		  "country": "Germany",
		  "litres": 165.8
		}, {
		  "country": "Australia",
		  "litres": 139.9
		}, {
		  "country": "Austria",
		  "litres": 128.3
		}, {
		  "country": "UK",
		  "litres": 99
		}, {
		  "country": "Belgium",
		  "litres": 60
		}, {
		  "country": "The Netherlands",
		  "litres": 50
		}];
*/	
	
	
	public ArrayList<Distribution> allByCountry(){
		ArrayList<Distribution> result = new ArrayList<Distribution>();
		
		try {
			
		PreparedStatement p;
		p = this.c.prepareStatement("SELECT Pays as Country, COUNT(*) as visit from textes where 1 group by Country");
		
		ResultSet rs = p.executeQuery();	
			while(rs.next()) {
				Distribution obj = new Distribution();
				obj.setValue(rs.getString(1));
				if (obj.getValue()=="") obj.setValue("Unknown Country");
				obj.setVisit(Integer.parseInt(rs.getString(2)));
				result.add(obj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Distribution> allByBrowser(){
		ArrayList<Distribution> result = new ArrayList<Distribution>();
		
		try {
			
		PreparedStatement p;
		p = this.c.prepareStatement("SELECT browser,COUNT(*) as visit from textes where 1 group by browser");
		
		ResultSet rs = p.executeQuery();	
			while(rs.next()) {
				Distribution obj = new Distribution();
				obj.setValue(rs.getString(1));
				if (obj.getValue()=="") obj.setValue("Unknown Browser");
				obj.setVisit(Integer.parseInt(rs.getString(2)));
				result.add(obj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public  ArrayList<Distribution> allByDay(){
		ArrayList<Distribution> result = new ArrayList<Distribution>();
		try {
			
		PreparedStatement p;
		p = this.c.prepareStatement("SELECT dayofweek(date) as day,count(*) as visit FROM `textes` WHERE 1 group by dayofweek(date)");
		
		ResultSet rs = p.executeQuery();	
			while(rs.next()) {
				Distribution obj = new Distribution();
				obj.setValue(rs.getString(1));
				obj.setVisit(Integer.parseInt(rs.getString(2)));
				result.add(obj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

	
	
	
	
	
	

}
