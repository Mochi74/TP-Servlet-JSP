package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.Texte;

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
	
	public List<Texte> all(){
		List<Texte> result = new ArrayList<Texte>();
		try {
			
		PreparedStatement p;
		p = this.c.prepareStatement("SELECT * FROM textes");
		
		ResultSet rs = p.executeQuery();
		
			while(rs.next()) {
				Texte t = new Texte();
				t.setId(rs.getString(1));
				t.setText(rs.getString(2));
				result.add(t);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
