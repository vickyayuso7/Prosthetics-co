package data_base.db.prosthetics;

import  java.sql.*;
import pojos.db.*;
import pojos.db.prosthetics.*;


import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SQLSelect{
	private static Connection c;
	private static List <String> colours;
	



	public static ArrayList<String>  getColours() throws SQLException{
		String colour="";
		colours=new ArrayList<String>();
		String Query="SELECT DISTINCT color FROM Prosthetics;";
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs=stm1.executeQuery(Query);
		stm1.close();
		while(rs.next()) {
			colour= rs.getString("color");
			colours.add(colour);
		}
		rs.close();
		return (ArrayList<String>) (colours);
	}
	
	public static ArrayList<String> getPaymentId() throws SQLException{
		String id;
		String Query="SELECT id FROM Payment;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getInt("id");
			idlist.add(id);
		}		
		return(idlist);
		
	}
	
	public static ArrayList<String> getMaterialId() throws SQLException{
		String id;
		String Query="SELECT id FROM Material;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getInt("id");
			idlist.add(id);
		}		
		return(idlist);
		
	}
	
	
	public static ArrayList<String> getProstheticId() throws SQLException{
		String id;
		String Query="SELECT id FROM Prosthetic;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getInt("id");
			idlist.add(id);
		}		
		return(idlist);
		
	}
	
	
	public static ArrayList<String> getClientId() throws SQLException{
		String id;
		String Query="SELECT id FROM Client;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getInt("id");
			idlist.add(id);
		}		
		return(idlist);
		
	}
	public static ArrayList<String> getClientNames() throws SQLException{
		String id;
		String Query="SELECT name FROM Client;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getString("name");
			idlist.add(id);
		}		
		return(idlist);
		
	}
	
	public static ArrayList<String> getAddressId() throws SQLException{
		String id;
		String Query="SELECT id FROM Address;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getInt("id");
			idlist.add(id);
		}		
		return(idlist);
		
	}
		
	
	public static ArrayList<String> getFeaturesId() throws SQLException{
		String id;
		String Query="SELECT id FROM Features;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getInt("id");
			idlist.add(id);
		}		
		return(idlist);
	}
//SELECT * features (asking for id)
	public static Features getFeaturesThroughId(int id) throws SQLException{
		String Query="SELECT * FROM Features WHERE id = ?;";
		Features feature=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, id);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			float price = rs.getFloat("best_price");
			String style= rs.getString("style");
			boolean enhanced= rs.getBoolean("enhanced_movement");
			boolean sensibility =rs.getBoolean("sensibility");
			int idp = rs.getInt("id");
			feature=new Features(idp, price, style, sensibility, enhanced);
		}
		return(feature);
	}
	//SELECT * features ( not asking for id)
		public static Features getFeatures() throws SQLException{
			String Query="SELECT * FROM Features;";
			Features feature=null;
			PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
			ResultSet rs = stm1.executeQuery();
			while(rs.next()) {
				float price = rs.getFloat("best_price");
				String style= rs.getString("style");
				boolean enhanced= rs.getBoolean("enhanced_movement");
				boolean sensibility =rs.getBoolean("sensibility");
				int idp = rs.getInt("id");
				feature=new Features(idp, price, style, sensibility, enhanced);
			}
			return(feature);
		}
	
	//	II) SELECT * FROM prosthetics ORDER BY typeOfAmputation DESC; 
	
	public static Prosthetics getProsthetics() throws SQLException{
		String Query="SELECT * FROM prosthetics ORDER BY type_of_amputation;";
		Prosthetics prosthetic=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			float size = rs.getFloat("size");
			float weight = rs.getFloat("weight");
			String type_of_funcionality= rs.getString("type_of_funcionality");
			String type_of_amputation= rs.getString("type_of_amputation");
			String color = rs.getString("color");
			float bestPrice = rs.getFloat("bestPrice");
			//Payment payment = rs.getPayment("payment");
			int id = rs.getInt("id");
			prosthetic=new Prosthetics(id, size, weight, type_of_funcionality, type_of_amputation,color,bestPrice);
		}
		return(prosthetic);
	}
	
//SELECT * FROM prosthetics (asking for i)
	
	public static Prosthetics getProstheticThroughId(int id) throws SQLException{
		String Query="SELECT * FROM prosthetics WHERE id = ?;";
		Prosthetics prosthetic=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, id);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			float size = rs.getFloat("size");
			float weight = rs.getFloat("weight");
			String type_of_funcionality= rs.getString("type_of_funcionality");
			String type_of_amputation= rs.getString("type_of_amputation");
			String color = rs.getString("color");
			float bestPrice = rs.getFloat("bestPrice");
			//Payment payment = rs.getPayment("payment");
			int idp = rs.getInt("id");
			prosthetic=new Prosthetics(id, size, weight, type_of_funcionality, type_of_amputation,color,bestPrice);
		}
		return(prosthetic);
	}
	
	//SELECT * FROM FEATURE (asking for id)
	public static Features getFeatureThroughId(int id) throws SQLException{
		String Query="SELECT * FROM Features WHERE id = ?;";
		Features feature=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, id);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			float price = rs.getFloat("best_price");
			String style= rs.getString("style");
			boolean enhanced= rs.getBoolean("enhanced_movement");
			boolean sensibility =rs.getBoolean("sensibility");
			int idp = rs.getInt("id");
			feature=new Features(idp, price, style, sensibility, enhanced);
		}
		return(feature);
	}
	
	//SELECT * FROM FEATUREs (not asking for id)
	
	public static ArrayList<Features> getFeature() throws SQLException{
		ArrayList <Features> features =new ArrayList <Features>();
		String Query="SELECT * FROM Features;";
		Features feature=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			float price = rs.getFloat("best_price");
			String style= rs.getString("style");
			boolean enhanced= rs.getBoolean("enhanced_movement");
			boolean sensibility =rs.getBoolean("sensibility");
			int id = rs.getInt("id");
			feature=new Features(id, price, style, sensibility, enhanced);
		}
		features.add(feature);
		return(features);
	}
	
	
	
	//VI) SELECT * FROM client;(not asking for id)
	
	public static ArrayList<Client> getClient() throws SQLException{
		ArrayList <Client> clients =new ArrayList <Client>();
		String Query="SELECT * FROM client;";
		Client client=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			
			String name= rs.getString("name");
			Date date_of_birth = rs.getDate("date_of_birth");
			String gender = rs.getString("gender");
			int id = rs.getInt("id");
			client=new Client (id,date_of_birth,name,gender);
		}
		clients.add(client);
		return(clients);
	}
	
	
	//VI) SELECT * FROM client; (Asking for id)
	
	public static ArrayList<Client> getClient(int id) throws SQLException{
		ArrayList <Client> clients =new ArrayList <Client>();
		String Query="SELECT * FROM client WHERE id =? ;";
		Client client=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1,id);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			
			String name= rs.getString("name");
			Date date_of_birth = rs.getDate("date_of_birth");
			String gender = rs.getString("gender");
			int idp = rs.getInt("id");
			client=new Client (id,date_of_birth,name,gender);
		}
		clients.add(client);
		return(clients);
	}
	
	
	
	
	//IX) SELECT * FROM address;(asking for id)
	public static ArrayList<Address> getAddressThroughtId(int id) throws SQLException{
		ArrayList <Address> addresses =new ArrayList <Address>();
		String Query="SELECT * FROM address WHERE id = ?;";
		Address address=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1,id);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			
			String country= rs.getString("country");
			int postCode = rs.getInt("postCode");
			String street = rs.getString("street");
			String town = rs.getString("town");
			int number=rs.getInt("number");
			int idp = rs.getInt("id");
			address=new Address (id,country, postCode,street, town,number);
		}
		addresses.add(address);
		return(addresses);
	}
	
	//IX) SELECT * FROM address;(not asking for id)
	public static ArrayList<Address> getAddress() throws SQLException{
		ArrayList <Address> addresses =new ArrayList <Address>();
		String Query="SELECT * FROM address;";
		Address address=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			
			String country= rs.getString("country");
			int postCode = rs.getInt("postCode");
			String street = rs.getString("street");
			String town = rs.getString("town");
			int number=rs.getInt("number");
			int id = rs.getInt("id");
			address=new Address (id,country, postCode,street, town,number);
		}
		addresses.add(address);
		return(addresses);
	}
	//VIII) SELECT city, town, country FROM address WHERE country <> 'Spain' ORDER BY 3 DESC;
	
	public static ArrayList<Address> getFromAddress() throws SQLException{
		ArrayList <Address> addresses =new ArrayList <Address>();
		String Query="SELECT city, town, country FROM address WHERE country <> 'Spain' ORDER BY 3 DESC;";
		Address address=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			
			String country= rs.getString("country");
			
			String town = rs.getString("town");
			String city=rs.getString("city");
			int id = rs.getInt("id");
			address=new Address (id,country,town,city);
		}
		addresses.add(address);
		return(addresses);
	}
	//getProstheticIdThruClientId
	public static ArrayList<String> getProstheticIdThruClientId(int ids) throws SQLException{
		String id;
		String Query="SELECT prosthetic_id FROM Client_Prosthetics WHERE client_id = ?;";
		ArrayList <String> idlist= new <String> ArrayList();
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, ids);
		ResultSet rs= stm1.executeQuery();
		while (rs.next()) {
			id=""+rs.getInt("id");
			idlist.add(id);
		}
		rs.close();
		stm1.close();
		return(idlist);
		
	}
	public static Material getMaterial(int id) throws SQLException{
		Material mat;
		String Query = "SELECT * FROM Material WHERE id = ?";
		PreparedStatement stm1 =SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, id);
		ResultSet rs = stm1.executeQuery();
		int ids=-1;
		String style="";
		String provider="";
		float price=-1;
		while(rs.next()) {
			ids =rs.getInt("id");
			style = rs.getString("type");
			provider =rs.getString("provider");
			price =rs.getFloat("priceModifier");
		}
		mat =new Material(ids, price, provider, style);
		return(mat);
		
	}
	//Falta:
	
	//SELECT * PAYMENT (asking for id)
	//SELECT * payment (not asking for id)
	//SELECT * MATERIAL (asking for id)
	//SELECT * MATERIAL (not asking for id)
	
	
	
	
	
}