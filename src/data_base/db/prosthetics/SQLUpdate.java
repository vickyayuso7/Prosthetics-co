package data_base.db.prosthetics;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import pojos.db.prosthetics.Address;
import pojos.db.prosthetics.Client;
import pojos.db.prosthetics.Features;
import pojos.db.prosthetics.Material;
import pojos.db.prosthetics.Payment;
import pojos.db.prosthetics.Prosthetics;

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
	
		public static void updateAddress(Address ad) throws SQLException{
			String update= "UPDATE Address SET country= ? SET postCode = ? SET "
					+ "street =? SET town = ? SET number = ? SET city = ? WHERE id =?";
			PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(update);
			stm1.setString(1, ad.getCountry());
			stm1.setInt(2, ad.getPostCode());
			stm1.setString(3, ad.getStreet());
			stm1.setString(4, ad.getTown());
			stm1.setInt(5, ad.getNumber());
			stm1.setString(6, ad.getCity());
			System.out.println(ad.getCountry()+"\n"+ ad.getId()+"\n"+ad.getPostCode()+"\n"+ad.getStreet()+"\n"+ad.getTown()+"\n"+ad.getNumber()+"\n"+ ad.getCity());
			stm1.setInt(7, ad.getId());
			stm1.executeUpdate();
			stm1.close();	
		}
		
		public static void updateMaterial(Material mat) throws SQLException{
			String update= "UPDATE Material SET priceModifier= ? SET type = ? SET "
					+ "provider =? WHERE id =?";
			PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(update);
			stm1.setFloat(1, mat.getPriceModifier());
			stm1.setString(2, mat.getType());
			stm1.setString(3, mat.getProvider());
			System.out.println(mat.getPriceModifier()+"\n"+ mat.getType()+"\n"+mat.getProvider()+"\n"+mat.getId());
			stm1.setInt(4, mat.getId());
			stm1.executeUpdate();
			stm1.close();	
		}
		
		
		public static void updateClient(Client cli) throws SQLException{
			String update= "UPDATE Client SET name= ? SET date_of_birth = ? SET "
					+ "gender =? SET address_id = ? WHERE id =?";
			PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(update);
			stm1.setString(1, cli.getName());
			stm1.setDate(2, cli.getDateOfBirth());
			stm1.setString(3, cli.getGender());
			
			System.out.println(cli.getName()+"\n"+cli.getDateOfBirth()+"\n"+cli.getGender()+"\n"+cli.getId());
			stm1.setInt(4, cli.getId());
			stm1.executeUpdate();
			stm1.close();	
		}
		
		
		public static void updatePayment(Payment pay) throws SQLException{
			String update= "UPDATE Payment SET iban= ? SET deadline = ? SET "
					+ "method =?  WHERE id =?";
			PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(update);
			stm1.setInt(1, pay.getIban());
			stm1.setDate(2, pay.getDeadline());
			stm1.setString(3, pay.getMethod());
			
			System.out.println(pay.getIban()+"\n"+pay.getDeadline()+"\n"+pay.getMethod()+"\n"+ pay.getId());
			stm1.setInt(4, pay.getId());
			stm1.executeUpdate();
			stm1.close();	
		}
		
		public static void updateProsthetics(Prosthetics pro) throws SQLException{
			String update= "UPDATE Prosthetics SET bestPrice= ? SET size = ? SET "
					+ "weight =? SET type_of_funcionality = ? SET color =? SET type_of_amputation = ? WHERE id =?";
			PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(update);
			stm1.setFloat(1, pro.getBestPrice());
			stm1.setFloat(2, pro.getSize());
			stm1.setFloat(3, pro.getWeight());
			stm1.setString(4, pro.getTypeOfFunctionality());
			stm1.setString(5, pro.getColor());
			stm1.setString(6, pro.getTypeOfAmputation());
			System.out.println(pro.getBestPrice()+"\n"+pro.getSize()+"\n"+pro.getWeight()+"\n"+pro.getTypeOfFunctionality()+"\n"+pro.getColor()+"\n"+pro.getTypeOfAmputation()+"\n"+pro.getId());
			stm1.setInt(7, pro.getId());
			stm1.executeUpdate();
			stm1.close();	
		}
			
			
		
}
