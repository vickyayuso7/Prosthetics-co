package data_base.db.prosthetics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLInsert {

	static void Insert(){
		try {
			// Open database connection
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");

			// Get the user info from the command prompt
			System.out.println("Please, input the payment info:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Deadline: ");
			String name = reader.readLine();
			System.out.print("Address: ");
			String address = reader.readLine();

			// Insert new record: begin
			Statement stmt = c.createStatement();
			String sql = "INSERT INTO departments (name, address) "
					+ "VALUES ('" + name + "', '" + address	+ "');";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Department info processed");
			System.out.println("Records inserted.");
			// Insert new record: end

			// Close database connection
			c.close();
			System.out.println("Database connection closed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}