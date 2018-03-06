package data_base.db.prosthetics;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnect {

	public static void main(String args[]) {
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
			c.close();
			System.out.println("Database connection closed.");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
		}
		
	}
}
