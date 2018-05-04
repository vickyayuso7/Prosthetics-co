package data_base.db.prosthetics;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pojos.db.prosthetics.Prosthetics;


public class SQLDelete {


	public static void deleteProsthetic(Prosthetics prostheticFull) throws SQLException{
		Connection c = SQLConnect.getConnection();
		String sql = "DELETE FROM Prosthetics WHERE id=?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, prostheticFull.getId());
		prep.executeUpdate();
		prep.close();
		
	}
	
}
