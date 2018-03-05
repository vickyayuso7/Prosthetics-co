package data_base.db.prosthetics;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnect {
	Connection connect;
	boolean connected;
	
	public SQLConnect() {
		connected=false;
		connect=null;
	}
	public void establishConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			connect.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
			connected=true;
		} catch (Exception e) {
			System.out.println("could not establish a connection.");
			//e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return(connect);
	}
	
	public void closeConnection() {
		try {
			this.connect.close();
			connected=false;
		}
		catch(Exception e) {
			System.out.println("could not close the database.");
		}
	}

	public boolean isConnected() {
		return(this.connected);
	}
}
