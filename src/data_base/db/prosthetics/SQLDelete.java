package data_base.db.prosthetics;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pojos.db.prosthetics.Prosthetics;


public class SQLDelete {


	public void SQLDeleteProsthetic (int id) throws IOException, SQLException {
		
			
			Connection c = SQLConnect.getConnection();
			//SQLDeleteFeatures(prosthetic);
			String sql = "DELETE FROM Posthetics WHERE id=?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, id);
			prep.executeUpdate();
			prep.close();
	}
	
}
