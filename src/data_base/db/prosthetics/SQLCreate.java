package data_base.db.prosthetics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLCreate {
	public static void Create(Connection c) throws Exception{
			Statement stmt1 = c.createStatement();
			String sql1 = "CREATE TABLE Payments "
					   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
					   + " deadline   DATE , "
					   + " iban  INTEGER	 NOT NULL, "
					   + " method  TEXT  NOT NULL)";
			System.out.println(sql1);
			stmt1.executeUpdate(sql1);
			stmt1.close(); 
			Statement stmt2 =  c.createStatement();
			String sql2 = "CREATE TABLE Material "
					   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT," 
					   + " priceModifier     REAL     NOT NULL, "
					   + " type      TEXT, "
					   + " provider  TEXT)";
			stmt2.executeUpdate(sql2);
			stmt2.close();
			Statement stmt3 = c.createStatement();
			String sql3 = "CREATE TABLE  Prosthetics"
					   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
					   + " bestPrice       FLOAT  	NOT NULL,"
					   + " size     FLOAT     NOT NULL, "
					   + " weight  FLOAT  	NOT NULL, "
					   + " type_of_functionality		TEXT,"
					   + " color   TEXT,"
					   + " type_of_amputation   TEXT   NOT NULL,"
					   + " payment_id   INTEGER  REFERENCES  Payments(id))";
			System.out.println(sql3);
			stmt3.executeUpdate(sql3);
			stmt3.close();
			Statement stmt4 = c.createStatement(); //many to many relationship tables//
			String sql4 = "CREATE TABLE Material_Prosthetics "
					   + "(material_id     INTEGER  REFERENCES Materials(id) ON UPDATE CASCADE ON DELETE SET NULL,"
					   + " prosthetic_id   INTEGER  REFERENCES Prosthetics(id) ON UPDATE CASCADE ON DELETE SET NULL,"
					   + " PRIMARY KEY (material_id,prosthetic_id))";
			System.out.println(sql4);
			stmt4.executeUpdate(sql4);
			stmt4.close();
			Statement stmt5 = c.createStatement();
			String sql5 = "CREATE TABLE Features "
					   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
					   + " style     TEXT , "
					   + " best_price     FLOAT     NOT NULL , "
					   + " sensibility      BOOLEAN, "
					   + " enhanced_movement    BOOLEAN)";
			System.out.println(sql5);
			stmt5.executeUpdate(sql5);
			stmt5.close();
			Statement stmt6 = c.createStatement(); //many to many relationship tables//
			String sql6 = "CREATE TABLE Features_Prosthetics "
					   + "(features_id     INTEGER  REFERENCES Features(id) ON UPDATE CASCADE ON DELETE SET NULL,"
					   + " prosthetic_id   INTEGER  REFERENCES Prosthetics(id) ON UPDATE CASCADE ON DELETE SET NULL,"
					   + " PRIMARY KEY (features_id,prosthetic_id))";
			System.out.println(sql6);
			stmt6.executeUpdate(sql6);
			stmt6.close();
			Statement stmt7 = c.createStatement();
			String sql7 = "CREATE TABLE Client "
					   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
					   + " name     TEXT     NOT NULL, "
					   + " date_of_birth      INTEGER, "
					   + " gender  TEXT,"
					   + " address_id   INTEGER  REFERENCES  Address(id))";
			System.out.println(sql7);
			stmt7.executeUpdate(sql7);
			stmt7.close();
			Statement stmt8 = c.createStatement(); //many to many relationship tables//
			String sql8 = "CREATE TABLE Client_Prosthetics "
					   + "(client_id     INTEGER  REFERENCES Client(id) ON UPDATE CASCADE ON DELETE SET NULL,"
					   + " prosthetic_id   INTEGER  REFERENCES Prosthetics(id) ON UPDATE CASCADE ON DELETE SET NULL,"
					   + " date DATETIME NOT NULL,"
					   + " PRIMARY KEY (client_id,prosthetic_id,date))"; 
			System.out.println(sql8);
			stmt8.executeUpdate(sql8);
			stmt8.close();
			Statement stmt9 = c.createStatement();
			String sql9 = "CREATE TABLE Address "
					   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
					   + " country     TEXT     NOT NULL, "
					   + " postCode      INTEGER    NOT NULL, "
					   + " street  TEXT   NOT NULL,"
					   + " town    TEXT   NOT NULL,"
					   + " city   TEXT   NOT NULL,"
					   + " number   INTEGER  NOT NULL)";
			stmt9.executeUpdate(sql9);
			
			stmt9.close();
			System.out.println("Tables created.");
	}
	public static void deleteDatabase(Connection c) throws SQLException{
		String str1= "DROP Client;";
		Statement stm1 = c.createStatement();
		stm1.executeUpdate(str1);
		str1 = "DROP Prosthetics;";
		stm1.executeUpdate(str1);
		str1 = "DROP Payments;";
		stm1.executeUpdate(str1);
		str1 ="DROP Materials;";
		stm1.executeUpdate(str1);
		str1 ="DROP Address;";
		stm1.execute(str1);
		stm1.close();
	}
}
