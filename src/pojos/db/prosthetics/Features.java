package pojos.db.prosthetics;
import java.sql.*;

class Features {
	
	static String Insert( int id, String style, String shape, boolean sensibility) {
		String report;
		boolean inserted;
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connect = DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			report= "connection established ";
			Statement st1= connect.createStatement();
			String insert= "INSERT INTO Features {(id, Style, Shape, Sensibility) VALUES ("+id+"," 
					+style+", "+shape+", "+sensibility;
			try {
			st1.executeUpdate(insert);
			inserted=true;
			}
			catch (Exception ex){
				report=report+"but failed to insert new data.";
				inserted=false;
			}
			st1.close();
			if(inserted==true) {
				report= report+"and managed to insert new data:"+id +style +shape +sensibility;
			}
			return(report);
		}
		catch(Exception Io) {
			report="unable to establish a connection with repository";
			return(report);
		}
		
	}
	static String delete(String style, String shape, boolean sensibility ) {
		String report;
		/*Deletion code for a specific combination of atributes*/
		report="not implemented yet.";
		return(report);
	}
	
}