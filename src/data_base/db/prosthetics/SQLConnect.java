package data_base.db.prosthetics;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnect {
	Connection connect;

	public void establishConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:./db/company.db");
			connect.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
		} catch (Exception e) {
			System.out.println("could not establish a connection.");
		}
	}
	public Connection getConnection() {
		return(this.connect);
	}
	public void closeConnection() {
		try {
			this.connect.close();
		}
		catch(Exception e) {
			System.out.println("could not close the database.");
		}
		
	}
}
