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
  
	
	public static int newClient (Client client, int address_id) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO Client (date_of_birth, name, gender, address_id) "
				+ "VALUES (?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setDate(1, client.getDateOfBirth());
		prep.setString(2, client.getName());
		prep.setString(3, client.getGender());
		prep.setInt(4, address_id);
		prep.executeUpdate();
		prep.close();
		String Query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement stm2 =SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs=stm2.executeQuery();
		int lastId = rs.getInt("lastId");
		return(lastId);
	}
	
	public static int newAddress (Address address) throws SQLException {
		Connection c = SQLConnect.getConnection();
		String sql = "INSERT INTO Address (country, postCode, street, town, number, city) "
				+ "VALUES (?,?,?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, address.getCountry());
		prep.setInt(2, address.getPostCode());
		prep.setString(3, address.getStreet());
		prep.setString(4, address.getTown());
		prep.setInt(5, address.getNumber());
		prep.setString(6, address.getCity());
		prep.executeUpdate();
		prep.close();
		String Query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement stm2 =SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs=stm2.executeQuery();
		int lastId = rs.getInt("lastId");
		return(lastId);
	}
	
	public static int newFeatures (Features features) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO Features (best_price, style, sensibility, enhanced_movement) "
				+ "VALUES (?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setFloat(1, features.getExtraPrice());
		prep.setString(2, features.getStyle());
		prep.setBoolean(3, features.getSensibility());
		prep.setBoolean(4, features.getEnhancedMovement());
		prep.executeUpdate();
		prep.close();
		String Query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement stm2 =SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs=stm2.executeQuery();
		int lastId = rs.getInt("lastId");
		return(lastId);
	}
	
	public static int newMaterial (Material material) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO Material (priceModifier, type, provider) "
				+ "VALUES (?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setFloat(1, material.getPriceModifier());
		prep.setString(2, material.getType());
		prep.setString(3, material.getProvider());
		prep.executeUpdate();
		prep.close();
		String Query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement stm2 =SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs=stm2.executeQuery();
		int lastId = rs.getInt("lastId");
		return(lastId);
	}
	
	
	public static int newPayment (Payment payment) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO Payments (deadline, iban, method) "
				+ "VALUES (?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setDate(1, payment.getDeadline());
		prep.setInt(2, payment.getIban());
		prep.setString(3, payment.getMethod());
		prep.executeUpdate();
		prep.close();
		String Query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement stm2 =SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs=stm2.executeQuery();
		int lastId = rs.getInt("lastId");
		return(lastId);
	}
	
	
	public static int newProsthetics (Prosthetics prosthetics,int payment_id) throws SQLException {
		Connection c = SQLConnect.getConnection();
		
		String sql = "INSERT INTO Prosthetics (bestPrice, size, weight, type_of_functionality, color, type_of_amputation, payment_id) "
				+ "VALUES (?,?,?,?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setFloat(1, prosthetics.getBestPrice());
		prep.setFloat(2, prosthetics.getSize());
		prep.setFloat(3, prosthetics.getWeight());
		prep.setString(4, prosthetics.getTypeOfFunctionality());
		prep.setString(5, prosthetics.getColor());
		prep.setString(6, prosthetics.getTypeOfAmputation());
		prep.setInt(7, payment_id);
		prep.executeUpdate();
		prep.close();
		String Query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement stm2 =SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs=stm2.executeQuery();
		int lastId = rs.getInt("lastId");
		return(lastId);
	}
	public static void newClient_Prosthetics(int client_id,int prosthetic_id) throws SQLException {
		String sql ="INSERT INTO Client_Prosthetics (client_id, prosthetic_id, date) VALUES (?,?,CURRENT_TIMESTAMP)";
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(sql);
		stm1.setInt(1, client_id);
		stm1.setInt(2, prosthetic_id);
		stm1.executeUpdate();
		stm1.close();
	}
	public static void newFeatures_Prosthetics(int feature_id, int prosthetic_id )throws SQLException {
		String sql ="INSERT INTO Features_Prosthetics (feature_id, prosthetic_id) VALUES (?,?)";
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(sql);
		stm1.setInt(1, feature_id);
		stm1.setInt(2, prosthetic_id);
		stm1.executeUpdate();
		stm1.close();
	}
	public static void newMaterial_Prosthetics(int material_id, int prosthetic_id )throws SQLException {
		String sql ="INSERT INTO Material_Prosthetics (material_id, prosthetic_id) VALUES (?,?)";
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(sql);
		stm1.setInt(1, material_id);
		stm1.setInt(2, prosthetic_id);
		stm1.executeUpdate();
		stm1.close();
	}
}