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
	
	public static void ShowClient(Client client){

		try {
			
		c = SQLConnect.getConnection();
		String sql = "SELECT * FROM client";
		
		 			
		Statement statement = c.prepareStatement(sql);
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			//Prosthetics prosthetics = new Prosthetics(id,bestPrice,size,weight,typeOfFunctionality,color,typeOfAmputation,payment);
			//System.out.println(prosthetics);
			//Address address = rs.getAddress("address");
			Date dateOfBirth = rs.getDate("dateOfBirth");
			
		}
		rs.close();
		statement.close();

		c.close();
		System.out.println("Database connection closed.");
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void  ShowAddress() throws SQLException{
		
		Connection c = SQLConnect.getConnection();
		
		String sql = "SELECT * FROM address";

		Statement statement = c.prepareStatement(sql);
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			/*
			int id = rs.getInt("id");
			String country = rs.getString("country");
			int postCode = rs.getInt("postCode");
			String street = rs.getString("street");
			String town = rs.getString("town");
			int number = rs.getInt("number");
			String city = rs.getString("city");

			
			Address addition =new Address();
			addition.setCity(city);
			
			Client client = new Client(client.setAddress(address),client.setDateOfBirth(dateOfBirth),client.setGender(gender),client.setId(id),
					client.setName(name),client.setProsthetics(prosthetics));
			*/
		}
		rs.close();
		
	}
	
	//public static void Show

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
	
	//VI) SELECT * FROM client;
	
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
	//IX) SELECT * FROM addresss;
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
	
	
}