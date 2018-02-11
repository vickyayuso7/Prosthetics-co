package pojos.db.prosthetics;
import java.sql.*;

class Material{
	static String Insert(float price, String type, String provider) {
		String report;
		boolean connected=false;
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connect= DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			report="Connection extablished ";
			connected=true;
			Statement stm1= connect.createStatement();
			String insert="INSERT INTO Materials (Price, Type, Provider) VALUES ("+price
					+", "+type+", "+provider;
			try {
				stm1.executeUpdate(insert);
				report="and managed to insert new data into tables";
			}
			catch(Exception sql) {
				report="but failed to insert new data into tables"
						+ "(Exception thrown from Material.java line 15)";
			}
			stm1.close();
		}
		catch(Exception sql){
			if(connected==false) {
				report="failed to connect to database (Exception thrown from Material.Java line 8)";
			}
			else {
				report="unknown Exception thrown from Materials.java,connection established but "
						+ "failed to accomplish task.";
			}
			
		}
		return(report);
	}
	/*supports all text format inputs.*/
	static String Insert(String price, String type, String provider) {
		String report;
		boolean connected=false;
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connect= DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			report="Connection extablished ";
			connected=true;
			Statement stm1= connect.createStatement();
			String insert="INSERT INTO Materials (Price, Type, Provider) VALUES ("+price
					+", "+type+", "+provider;
			try {
				stm1.executeUpdate(insert);
				report="and managed to insert new data into tables";
			}
			catch(Exception sql) {
				report="but failed to insert new data into tables"
						+ "(Exception thrown from Material.java line 15)";
			}
			stm1.close();
		}
		catch(Exception sql){
			if(connected==false) {
				report="failed to connect to database (Exception thrown from Material.Java line 8)";
			}
			else {
				report="unknown Exception thrown from Materials.java,connection established but "
						+ "failed to accomplish task.";
			}
			
		}
		return(report);
	}
	static String delete() {
		/*deletion code goes here*/
		String report="not implemented yet";
		return (report);
	}
}