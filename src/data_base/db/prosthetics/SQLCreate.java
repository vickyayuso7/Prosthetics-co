package data_base.db.prosthetics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLCreate {
	
	static void Create() {
		try {
			// Open database connection
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
			
			// Create tables: begin
			// Statements serve to tell the data table what to do
			Statement stmt1 = c.createStatement();
			//tip name o the object typed then add a then look up for the desired command
			//requiers knowing the fucking method
			//crl space does all the job for ya.
			String sql1 = "CREATE TABLE Payments "
					   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
					   + " deadline   DATE , "
					   + " isbn  INTEGER	 NOT NULL"
					   + " method  TEXT  NOT NULL)";
			stmt1.executeUpdate(sql1);
			//auto updates the statement
			stmt1.close(); 
			//always close or fuck up everything//
			Statement stmt2 = c.createStatement();
			String sql2 = "CREATE TABLE Material "
					   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT," 
					   + " price     INTEGER     NOT NULL, "
					   + " type      TEXT, "
					   + " provider  TEXT)";
			stmt2.executeUpdate(sql2);
			stmt2.close();
			Statement stmt3 = c.createStatement();
			String sql3 = "CREATE TABLE  Prosthetics"
					   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
					   + " size     FLOAT     NOT NULL, "
					   + " weight  FLOAT  	NOT NULL, "
					   + " type_of_functionality		TEXT,"
					   + " color   TEXT,"
					   + " type_of_amputation   TEXT   NOT NULL,"
					   + " payment_id   INTEGER  REFERENCES  Payments(id))";
			stmt3.executeUpdate(sql3);
			stmt3.close();
			Statement stmt4 = c.createStatement(); //many to many relationship tables//
			String sql4 = "CREATE TABLE Material-Prosthetics "
					   + "(material_id     INTEGER  REFERENCES Materials(id) ON UPDATE CASCADE ON DELETE SET NULL,"
					   + " prosthetic_id   INTEGER  REFERENCES Prosthetics(id) ON UPDATE CASCADE ON DELETE SET NULL,"
					   + " PRIMARY KEY (material_id,prosthetic_id))";
			stmt4.executeUpdate(sql4);
			stmt4.close();
			Statement stmt5 = c.createStatement();
			String sql5 = "CREATE TABLE Features "
					   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
					   + " style     TEXT , "
					   + " sensibility      BOOLEAN, "
					   + " enhanced_movement    BOOLEAN)";
			stmt5.executeUpdate(sql5);
			stmt5.close();
			Statement stmt6 = c.createStatement(); //many to many relationship tables//
			String sql6 = "CREATE TABLE Features-Prosthetics "
					   + "(features_id     INTEGER  REFERENCES Features(id) ON UPDATE CASCADE ON DELETE SET NULL,"
					   + " prosthetic_id   INTEGER  REFERENCES Prosthetics(id) ON UPDATE CASCADE ON DELETE SET NULL,"
					   + " PRIMARY KEY (features_id,prosthetic_id))";
			stmt6.executeUpdate(sql6);
			stmt6.close();
			Statement stmt7 = c.createStatement();
			String sql7 = "CREATE TABLE Client "
					   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
					   + " name     TEXT     NOT NULL, "
					   + " age      INTEGER, "
					   + " gender  TEXT,"
					   + " measures    INTEGER   NOT NULL,"
					   + " address_id   INTEGER  REFERENCES  Address(id))";
			stmt7.executeUpdate(sql7);
			stmt7.close();
			Statement stmt8 = c.createStatement(); //many to many relationship tables//
			String sql8 = "CREATE TABLE Client-Prosthetics "
					   + "(client_id     INTEGER  REFERENCES Client(id) ON UPDATE CASCADE ON DELETE SET NULL,"
					   + " prosthetic_id   INTEGER  REFERENCES Prosthetics(id) ON UPDATE CASCADE ON DELETE SET NULL,"
					   + " PRIMARY KEY (client_id,prosthetic_id))";
			stmt8.executeUpdate(sql8);
			stmt8.close();
			Statement stmt9 = c.createStatement();
			String sql9 = "CREATE TABLE Address "
					   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
					   + " country     TEXT     NOT NULL, "
					   + " post_code      INTEGER    NOT NULL, "
					   + " street  TEXT   NOT NULL,"
					   + " town    TEXT   NOT NULL,"
					   + " number   INTEGER  NOT NULL)";
			stmt9.executeUpdate(sql9);
			stmt9.close();
			
			System.out.println("Tables created.");
			
			// Close database connection
			c.close();
			System.out.println("Database connection closed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}