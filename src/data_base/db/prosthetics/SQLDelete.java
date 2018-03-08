package data_base.db.prosthetics;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pojos.db.prosthetics.Address;
import pojos.db.prosthetics.Client;
import pojos.db.prosthetics.Prosthetics;

public class SQLDelete {

	public void SQLDeleteProsthetic (Prosthetics prosthetic) throws IOException, SQLException {
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection c= DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			
		}
		
		try {
			
			String sql = "DELETE FROM Posthetics WHERE id=?";
			PreparedStatement prep = SQLConnect.c.prepareStatement(sql);
			prep.setInt(1, prosthetic.getId());
			prep.executeUpdate();
			prep.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println();
			
		}
		
	}
	
}
