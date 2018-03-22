package data_base.db.prosthetics;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import pojos.db.prosthetics.Features;

public class SQLUpdate{
	
	public static void updateFeatures(Features feat) throws SQLException{
		String update= "UPDATE Features SET style=?, SET best_price = ?, SET"
				+ "sensibility =?, SET enhanced_movement = ?, WHERE id ="+feat.getId()+";";
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(update);
		stm1.setString(1, feat.getStyle());
		stm1.setFloat(2, feat.getExtraPrice());
		stm1.setBoolean(3, feat.getSensibility());
		stm1.setBoolean(4, feat.getEnhancedMovement());
		stm1.executeUpdate();
		stm1.close();
	}
}