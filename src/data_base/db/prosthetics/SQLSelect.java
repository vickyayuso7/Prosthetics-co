package data_base.db.prosthetics;

import  java.sql.*;
import pojos.db.*;
import pojos.db.prosthetics.*;

import java.sql.Connection;
import java.sql.Date;

public class SQLSelect{
	
	public static void ShowClient(Client client){

		try {
			
		Connection c = SQLConnect.getConnection();
		
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
	
	
	public static  ShowAddress(){
		
		Connection c = SQLConnect.getConnection();
		
		String sql = "SELECT * FROM address";

		Statement statement = c.prepareStatement(sql);
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
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
			
		}
		
	}
	
	public static void Show
}