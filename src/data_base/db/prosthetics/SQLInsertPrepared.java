package data_base.db.prosthetics;
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


import pojos.db.prosthetics.Client;
public class SQLInsertPrepared{
		private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		private static Connection c;

		private static //list// printClients() throws SQLException {
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM clients";
			ResultSet rs = stmt.executeQuery(sql);
			//create empty list of clients
			while (rs.next()) {
				int id = rs.getInt("id");
				Date date_of_birth = rs.getInt("date_of_birth");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				Client client = new Client(id, date_of_birth, name, gender);
				System.out.println(client);//add the client to the list
			}
			rs.close();
			stmt.close();//return the list
		}
		
		
}