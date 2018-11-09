package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class WordDao extends DaoConnection {
	
	private static WordDao SINGLETON = null;
	
	private WordDao() {
		
	}
	
	public static WordDao getInstance() {
		if (SINGLETON==null) SINGLETON = new WordDao();
		
		if (SINGLETON.c==null) {
			SINGLETON.openConnection();	
		}
		return SINGLETON;
	}
	
	public String ajout(String texteId, String mot, Integer frequence) {
		
		
		try {
			PreparedStatement p = c.prepareStatement("INSERT INTO frequence (textId,mot,frequence) VALUES (?,?,?)");
			p.setString(1,texteId);
			p.setString(2,mot);
			p.setInt(3,frequence);
			p.executeUpdate();
			return texteId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
		
	

}
