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

public class SQLInsert2 {

	
	public static void newClient (Client client) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO clients (date_of_birth, name, gender) "
				+ "VALUES (?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setDate(1, client.getDate_of_birth());
		prep.setString(2, client.getName());
		prep.setString(3, client.getGender());
		
		prep.executeUpdate();
		prep.close();
	}
	
	public static void newAddress (Address address) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO addresss (country, postCode, street, town, number) "
				+ "VALUES (?,?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, address.getCountry());
		prep.setInt(2, address.getPostCode());
		prep.setString(3, address.getStreet());
		prep.setString(4, address.getTown());
		prep.setInt(5, address.getNumber());
		
		prep.executeUpdate();
		prep.close();
	}
	
	public static void newFeatures (Features features) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO features (extra_price, style, sensibility, enhanced_movement) "
				+ "VALUES (?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setFloat(1, features.getExtra_price());
		prep.setString(2, features.getStyle());
		prep.setBoolean(3, features.getSensibility());
		prep.setBoolean(4, features.getEnhanced_movement());
		
		prep.executeUpdate();
		prep.close();
	}
	
	public static void newMaterial (Material material) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO material (price_modifier, type, provider) "
				+ "VALUES (?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setFloat(1, material.getPrice_modifier());
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
		
		String sql = "INSERT INTO prosthetics (best_price, size, weight, type_of_functionality, color, type_of_amputation) "
				+ "VALUES (?,?,?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setFloat(1, prosthetics.getBest_price());
		prep.setFloat(2, prosthetics.getSize());
		prep.setFloat(3, prosthetics.getWeight());
		prep.setString(4, prosthetics.getType_of_functionality());
		prep.setString(5, prosthetics.getColor());
		prep.setString(6, prosthetics.getType_of_amputation());
		
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