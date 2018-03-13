package data_base.db.prosthetics;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pojos.db.prosthetics.Prosthetics;
import pojos.db.prosthetics.Features;

public class SQLDelete {

	//show the prosthetics 
	
public void SQLDeleteFeatures (Features features) throws IOException, SQLException {
		
		try {
			
			Connection c = SQLConnect.getConnection();
			
			String sql = "DELETE FROM Features WHERE id=?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, features.getId());
			prep.executeUpdate();
			prep.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println();
			
		}
		
	}

	public void SQLDeleteProsthetic (Prosthetics prosthetic,Features features ) throws IOException, SQLException {
		
		try {
			
			Connection c = SQLConnect.getConnection();
			
			SQLDeleteFeatures(features);
			String sql = "DELETE FROM Posthetics WHERE id=?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, prosthetic.getId());
			prep.executeUpdate();
			prep.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			System.out.println();
			
		}
		
	}
	
}
