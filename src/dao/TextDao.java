package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class TextDao extends DaoConnection {
	
	private static TextDao SINGLETON = null;
	
	
	private TextDao() {
		
	}
	
	public static TextDao getInstance() {
		if (SINGLETON==null) 
			SINGLETON = new TextDao();
			
		if (SINGLETON.c==null) {
			SINGLETON.openConnection();	
		}
		return SINGLETON;
	}
	

	
	public String save(String texte) {
		
		String id = UUID.randomUUID().toString()+"-"+System.currentTimeMillis();
		try {
			PreparedStatement p = this.c.prepareStatement("INSERT INTO textes (id,texte) VALUES (?,?)");
			p.setString(1,id);
			p.setString(2,texte);
			p.executeUpdate();
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

	
	
	
	
	
	

}
