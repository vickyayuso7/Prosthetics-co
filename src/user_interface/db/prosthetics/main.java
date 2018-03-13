package user_interface.db.prosthetics;
import pojos.db.prosthetics.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;

import data_base.db.prosthetics.SQLConnect;
import data_base.db.prosthetics.SQLInsert;

import java.sql.SQLException;
import java.io.IOException;

public class main{
	public static void main( String args[]) throws IOException {
		try {//country, postCode, street, town, number
			SQLConnect.establishConnection();
			
			imprimir("country:");
			BufferedReader consola= new BufferedReader(new InputStreamReader(System.in));
			String country= consola.readLine();
			imprimir("postCode:");
			String read= consola.readLine();
			int postCode= Integer.parseInt(read);
			imprimir("street:");
			String street= consola.readLine();
			imprimir("town:");
			String town= consola.readLine();
			imprimir("number:");
			read= consola.readLine();
			int number= Integer.parseInt(read);
			
			Address address= new Address(country, postCode, street, town, number);
			imprimir(""+address);
			SQLInsert.newAddress(address);
			
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
	}
	static void imprimir(String s) {
		System.out.println(s);
	}
	
}

