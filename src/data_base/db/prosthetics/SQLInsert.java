package data_base.db.prosthetics;

import  java.sql.*;
import pojos.db.prosthetics.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SQLInsert {

	
	public static void newClient (Client client) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO clients (dateOfBirth, name, gender) "
				+ "VALUES (?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setDate(1, client.getDateOfBirth());
		prep.setString(2, client.getName());
		prep.setString(3, client.getGender());
		
		prep.executeUpdate();
		prep.close();
	}
	
	public static void newAddress (Address address) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		
		
		System.out.println("OK1");
		
		
		String sql = "INSERT INTO address (country, postCode, street, town, number) "
				+ "VALUES (?,?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, address.getCountry());
		prep.setInt(2, address.getPostCode());
		prep.setString(3, address.getStreet());
		prep.setString(4, address.getTown());
		prep.setInt(5, address.getNumber());
		
		System.out.println("OK2");
		
		prep.executeUpdate();
		prep.close();
		System.out.println("OK3");
	}
	
	public static void newFeatures (Features features) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO features (extra_price, style, sensibility, enhancedMovement) "
				+ "VALUES (?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setFloat(1, features.getExtraPrice());
		prep.setString(2, features.getStyle());
		prep.setBoolean(3, features.getSensibility());
		prep.setBoolean(4, features.getEnhancedMovement());
		
		prep.executeUpdate();
		prep.close();
	}
	
	public static void newMaterial (Material material) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO material (priceModifier, type, provider) "
				+ "VALUES (?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setFloat(1, material.getPriceModifier());
		prep.setString(2, material.getType());
		prep.setString(3, material.getProvider());
		
		
		prep.executeUpdate();
		prep.close();
	}
	
	
	public static void newPayment (Payment payment) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO payment (deadline, iban, method) "
				+ "VALUES (?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setDate(1, payment.getDeadline());
		prep.setInt(2, payment.getIban());
		prep.setString(3, payment.getMethod());
		
		
		prep.executeUpdate();
		prep.close();
	}
	
	
	public static void newProsthetics (Prosthetics prosthetics) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO prosthetics (bestPrice, size, weight, typeOfFunctionality, color, typeOfAmputation) "
				+ "VALUES (?,?,?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setFloat(1, prosthetics.getBestPrice());
		prep.setFloat(2, prosthetics.getSize());
		prep.setFloat(3, prosthetics.getWeight());
		prep.setString(4, prosthetics.getTypeOfFunctionality());
		prep.setString(5, prosthetics.getColor());
		prep.setString(6, prosthetics.getTypeOfAmputation());
		
		prep.executeUpdate();
		prep.close();
	}
	
	
	
	
	public static void main(String args[]) {
		try {
		
			
			
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}