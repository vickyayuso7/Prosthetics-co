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
import java.util.ArrayList;
import java.util.List;

import pojos.db.prosthetics.Client;
import pojos.db.prosthetics.Prosthetics;

public class SQLSelect {
	
		private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		private static Connection c;

		private static List<Client> selectClients() throws SQLException {
			
			List<Client> clients = new ArrayList<Client>();
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM clients";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				int id = rs.getInt("id");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				Client client = new Client(id, dateOfBirth, name, gender);
				clients.add(client);
				System.out.println(client);
				
			}
			
			rs.close();
			stmt.close();
			return clients;

		}
				
}