package data_base.db.prosthetics;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnect {
private static	Connection connect;
private static	boolean connected;
	
	 static public void establishConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			connect.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
			connected=true;
		} catch (Exception e) {
			System.out.println("could not establish a connection.");
			e.printStackTrace();
		}
	}
	
	static public Connection getConnection() {
		return(connect);
	}
	
	static public void closeConnection() {
		try {
			connect.close();
			connected=false;
		}
		catch(Exception e) {
			System.out.println("could not close the database.");
		}
	}

	static public boolean isConnected() {
		return(connected);
	}
}
