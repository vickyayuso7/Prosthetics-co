package data_base.db.prosthetics;

import  java.sql.*;
import pojos.db.prosthetics.*;

public class SQLInsert {
String report;
Boolean failed;
String insert;
//Added a constructor so that everyone is happy about the inserting method being an object.
//you mysogenist objectifying pieces of trash.
public void SQLinsert() {
	this.report="not connected";
	this.failed=false;
	this.insert="";
}
/*one method that may be called upon whenever needed that does the job of inserting whatever is 
 * passed on (hopefully some useful objects that have to be PUBLIC in order for this package to 
 * make use of them and not any random garbage)*/
	String Insert(Material mat, Client cln, Features ftr, Address adr, Payment pmnt, Prosthetics prstc )
	{
		this.failed=false;
		this.insert="";
		this.report="";
		try {
			/*BTW the code does a very poor job of checking if all given parameters are valid
			 * insertions. It should check for nulls where there shouldn't be any and those related 
			 * things... It could be handled by another method but just for the sake of being 
			 * f*cking hysterical about mistakes, I will implement it... Later...*/
			Class.forName("org.sqlite.JDBC");
			Connection c= DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			report="Connection established ";
			Statement stm1=c.createStatement();
			try {
				this.insert="INSERT INTO Address (id, country, post code, street,town, number) VALUES ("
						+adr.getId()+","+adr.getCountry() + ", " +adr.getPostCode()+", "+adr.getStreet()+
						", "+adr.getTown()+", "+adr.getNumber()+ ")";
				stm1.executeUpdate(insert);
				report=report+"and inserted Adress:"+adr.getId()+"/n";
			}
			catch(Exception ex){
				report=report+"but failed to insert address ";
				failed=true;
			}
			try {
				if(failed ==false) {
					this.insert="INSERT INTO Client (id, name, date_of_birth, gender, address_id)"
							+"VALUES ("+cln.getId()+","+ cln.getName()+", "+cln.getDate_of_birth()+", "
							+cln.getGender()+", "+cln.getAddress()+")";
					stm1.executeUpdate(insert);
					report=report+"inserted Client:"+cln.getName()+"/n";
				}
				else {
					System.out.println(report+"and therefore could not proceed on./n");
				}
			}
			catch(Exception ex) {
					report=report+"but failed to insert client";
					failed=true;
			}
			try {
				if(failed==false) {
					this.insert="INSERT INTO Features (id, style, sensibility,enhanced_movement)"
							+"VALUES ("+ftr.getId()+", "+ftr.getStyle()+", "+ftr.getSensibility()
							+", "+ftr.getEnhanced_movement()+")";
					stm1.executeUpdate(insert);
					report=report+"inserted Features"+ftr.getId()+"/n";
				}
				else {
					report=report+"and therefore could not proceed on./n";
				}
			}
			catch(Exception ex) {
				report=report+"but failed to insert features";
				failed=true;
			}
			try {
				if(failed==false) {
					this.insert="INSERT INTO Material (id, type, price, provider) VALUES ("
							+mat.getId()+", "+mat.getType()+", "+mat.getPrice_modifier()+", "+mat.getProvider()
							+")";
					stm1.executeUpdate(insert);
					report=report+"inserted material"+mat.getId()+"/n";
				}
				else {
					report=report+"and therefore could not proceed on,/n";
				}
			}
			catch(Exception ex) {
				report =report+"but failed to insert Materials";
				failed=true;
			}
			try {
				if(failed==false) {
					this.insert="INSERT INTO Payments (id, deadline, iban, method) VALUES("
							+pmnt.getId()+", "+pmnt.getDeadline()+", "+pmnt.getIban()+", "
							+pmnt.getMethod()+")";
					stm1.executeUpdate(insert);
					report=report+"inserted payments"+pmnt.getId()+"/n";
				}
				else {
					report=report+"and therefore could not proceed on,/n";
				}
			}
			catch(Exception ex) {
				report=report+"but failed to insert Payments";
				failed=true;
			}
			try {
				if(failed==false) {
					this.insert="INSERT INTO Prosthetics (id, size, weight, type_of_functionality"
							+", color, type_of_amputation, payment_id) VALUES("+prstc.getId()+", "
							+prstc.getSize()+", "+prstc.getWeight()+", "+prstc.getType_of_functionality()
							+", "+prstc.getColor()+", "+prstc.getType_of_amputation()+", "+prstc.getPayment()
							+")";
					stm1.executeUpdate(insert);
					report=report+"inserted prosthetics"+prstc.getId()+"/n";
				}
				else {
					report=report +"and therefore could not proceed on /n";
					failed=true;
				}
			}
			catch(Exception ex) {
				report=report+"but failed to insert prosthetics";
				failed=true;
			}
			c.close();
		}
		catch(Exception sql) {
			report="failed to conect to database";
		}
		return(report);
	}
	/*If you are reading this you probably skimmed through the code wondering WTF was going on
	 * let me enlight you,this is taking all the possible entities and inserting them in one go.
	 * supposedly used when a new client is created with all it's data being introduced at once
	 * I will use Java's overload policy to create a few variants of the same command that will
	 * allow users to insert certain tables without having to give in the whole badge */
	//the last issue was fixed. 
	String Insert(Material mat) {
		this.report="";
		this.insert="";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			Statement stm1= c.createStatement();
			try {
					this.insert="INSERT INTO Material (id, type, price, provider) VALUES ("
							+mat.getId()+", "+mat.getType()+", "+mat.getPrice_modifier()+", "+mat.getProvider()
							+")";
					stm1.executeUpdate(insert);
					report=report+"inserted material"+mat.getId()+"/n";
			}
			catch(Exception ex) {
				report ="failed to insert Materials";
			}
			c.close();
		}
		catch(Exception ex) {
			report="failed to connect to database";
		}
		return(this.report);
	}
	String Insert(Features ftr) {
		this.report="";
		this.report="";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c=DriverManager.getConnection("jdbc.sqlite:./db/prosthetics");
			Statement stm1=c.createStatement();
			try {
				this.insert="INSERT INTO Features (id, style, sensibility,enhanced_movement)"
						+"VALUES ("+ftr.getId()+", "+ftr.getStyle()+", "+ftr.getSensibility()
						+", "+ftr.getEnhanced_movement()+", "+ftr.getExtra_price()
						+")";
				stm1.executeUpdate(insert);
				report="inserted Features"+ftr.getId()+"/n";
				c.close();
			}
			catch(Exception ex) {
				report="failed to insert features";
			}
		}
		catch(Exception ex) {
			report="failed to connect to database";
		}
		return (report);
	}
	String Insert(Prosthetics prstc) {
		this.report="";
		this.report="";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c=DriverManager.getConnection("jdbc.sqlite:./db/prosthetics");
			Statement stm1=c.createStatement();
			try {
				this.insert="INSERT INTO Prosthetics (id, size, weight, type_of_functionality"
						+", color, type_of_amputation, payment_id) VALUES("+prstc.getId()+", "+prstc.getBest_price()+","
						+prstc.getSize()+", "+prstc.getWeight()+", "+prstc.getType_of_functionality()
						+", "+prstc.getColor()+", "+prstc.getType_of_amputation()+", "+prstc.getPayment()
						+")";
				stm1.executeUpdate(insert);
				report="inserted prosthetics"+prstc.getId()+"/n";
			}
			catch(Exception ex) {
				report="failed to insert prosthetics";
			}
			c.close();
		}
		catch(Exception ex) {
			report="failed to connect to database";
		}
		return(report);
	}
	String Insert(Address adr) {
		this.report="";
		this.report="";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c=DriverManager.getConnection("jdbc.sqlite:./db/prosthetics");
			Statement stm1=c.createStatement();
			try {
				this.insert="INSERT INTO Address (id, country, post code, street,town, number) VALUES ("
						+adr.getId()+","+adr.getCountry() + ", " +adr.getPostCode()+", "+adr.getStreet()+
						", "+adr.getTown()+", "+adr.getNumber()+ ")";
				stm1.executeUpdate(insert);
				report="inserted Adress:"+adr.getId()+"/n";
			}
			catch(Exception ex){
				report="failed to insert address ";
			}
			c.close();
		}
		catch(Exception ex) {
			report="failed to connect to database";
		}
		return(report);
	}
	String Insert(Client cln) {
		this.report="";
		this.insert="";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			Statement stm1= c.createStatement();
			try {
				this.insert="INSERT INTO Client (id, name, date_of_birth, gender, measures, address_id)"
						+"VALUES ("+cln.getId()+","+ cln.getName()+", "+cln.getDate_of_birth()+", "
						+cln.getGender()+","+cln.getAddress()+")";
				stm1.executeUpdate(insert);
				report=report+"inserted Client:"+cln.getName()+"/n";
			}
			catch(Exception ex) {
					report="failed to insert client";
			}
			c.close();
		}
		catch(Exception ex) {
			report="failed to connect to database";
		}
		return(report);
	}
	String Insert(Payment pmnt) {
		this.report="";
		this.insert="";
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:./db/prosthetics");
			Statement stm1= c.createStatement();
			try {
				this.insert="INSERT INTO Payments (id, deadline, iban, method) VALUES("
						+pmnt.getId()+", "+pmnt.getDeadline()+", "+pmnt.getIban()+", "
						+pmnt.getMethod()+")";
				stm1.executeUpdate(insert);
				report=report+"inserted payments"+pmnt.getId()+"/n";
			}
			catch(Exception ex){
				report="failed to insert address ";
			}
			c.close();
	}
		catch(Exception ex) {
			report="failed to connect to database";
		}
		return(report);
	}
/*methods added to enable the creation of only one object instead of having to give in a complete
 * set of data.*/

}
