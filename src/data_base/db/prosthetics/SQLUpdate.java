package data_base.db.prosthetics;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import pojos.db.prosthetics.Features;

public class SQLUpdate{
	
	public static void updateFeatures(Features feat) throws SQLException{
		String update= "UPDATE Features SET style= ? SET best_price = ? SET "
				+ "sensibility =? SET enhanced_movement = ? WHERE id =?";
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(update);
		stm1.setString(1, feat.getStyle());
		stm1.setFloat(2, feat.getExtraPrice());
		stm1.setBoolean(3, feat.getSensibility());
		stm1.setBoolean(4, feat.getEnhancedMovement());
		System.out.println(feat.getStyle()+"\n"+feat.getId()+"\n"+feat.getExtraPrice()+"\n"+feat.getEnhancedMovement()+"\n"+feat.getSensibility());
		stm1.setInt(5, feat.getId());
		stm1.executeUpdate();
		stm1.close();
	}
}