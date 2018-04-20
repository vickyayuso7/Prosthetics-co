package user_interface.db.prosthetics;
import pojos.db.prosthetics.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;

import data_base.db.prosthetics.SQLConnect;
import data_base.db.prosthetics.SQLCreate;
import data_base.db.prosthetics.SQLInsert;

import java.sql.SQLException;
import java.io.IOException;

public class main{
	public static void main( String args[]) throws IOException {
		//SQLConnect.establishConnection();
		try {
			SQLCreate.Create(SQLConnect.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		imprimir("country:");
		BufferedReader consola= new BufferedReader(new InputStreamReader(System.in));
		String country= consola.readLine();
		imprimir("post_code:");
		String read= consola.readLine();
		int post_code= Integer.parseInt(read);
		imprimir("street:");
		String street= consola.readLine();
		imprimir("town:");
		String town= consola.readLine();
		imprimir("number:");
		read= consola.readLine();
		int number= Integer.parseInt(read);
		int id=1;
		
		
		
		
		Address address= new Address(id, country, post_code, street, town, number);
		imprimir(""+address);
		try {
			SQLInsert.newAddress(address);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static void imprimir(String s) {
		System.out.println(s);
	}
	
}

