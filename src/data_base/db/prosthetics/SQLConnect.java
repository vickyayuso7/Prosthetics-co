package data_base.db.prosthetics;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnect {
<<<<<<< HEAD
private static	Connection connect;
private static	boolean connected;
=======

	Connection connect;
	boolean connected;
>>>>>>> branch 'master' of https://github.com/vickyayuso7/Prosthetics-co.git
	
<<<<<<< HEAD
	 static public void establishConnection() {
=======
	public SQLConnect() {
	
		connected = false;
		connect = null;
		
	}
	
	public void establishConnection() {
	
>>>>>>> branch 'master' of https://github.com/vickyayuso7/Prosthetics-co.git
		try {
		
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			connect.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
			connected=true;
<<<<<<< HEAD
		} catch (Exception e) {
			System.out.println("could not establish a connection.");
			e.printStackTrace();
=======
			
		} catch (Exception ex) {
		
			System.out.println("Could not connect to the data base.");
			ex.printStackTrace();
			
>>>>>>> branch 'master' of https://github.com/vickyayuso7/Prosthetics-co.git
		}
		
	}
	
<<<<<<< HEAD
	static public Connection getConnection() {
=======
	public Connection getConnection() {
	
>>>>>>> branch 'master' of https://github.com/vickyayuso7/Prosthetics-co.git
		return(connect);
		
	}
	
<<<<<<< HEAD
	static public void closeConnection() {
=======
	public void closeConnection() {
	
>>>>>>> branch 'master' of https://github.com/vickyayuso7/Prosthetics-co.git
		try {
<<<<<<< HEAD
			connect.close();
=======
		
			this.connect.close();
>>>>>>> branch 'master' of https://github.com/vickyayuso7/Prosthetics-co.git
			connected=false;
			
		} catch(Exception ex) {
		
			System.out.println("could not close the database.");
			ex.printStackTrace();
			
		}
		
	}

<<<<<<< HEAD
	static public boolean isConnected() {
		return(connected);
=======
	public boolean isConnected() {
	
		return(this.connected);
		
>>>>>>> branch 'master' of https://github.com/vickyayuso7/Prosthetics-co.git
	}
	
}

