package wizard_Handler;
import java.sql.SQLException;

import data_base.db.prosthetics.*;
import pojos.db.prosthetics.*;
 public class WizardHandler{
	 
 	SQLCreate creatorWand;
 	SQLDrop magicBroom;
 	SQLUpdate updaterLord;
 	
 	public WizardHandler(){
 		this.creatorWand= new SQLCreate();
 		this.magicBroom= new SQLDrop();
 		this.updaterLord= new SQLUpdate();
 		SQLConnect.establishConnection();
 	 }
 	/*
	public String createTables(){
		try {
			SQLCreate.Create(connecterMaThingy.getConnection());
			return("managed to create tables");
		}
		catch (Exception ex){
			return("failed to create tables");
		}
	}
	public void appClosed() {
		connecterMaThingy.closeConnection();
	}*/
	public String newClient(Client cln, Address adr, Payment pmn, Prosthetics prs) {
		String report="all clear";
		try {
			SQLInsert.newClient(cln);
		} catch (SQLException e) {
			e.printStackTrace();
			report="failed client insertion";
		}
		try {
			SQLInsert.newAddress(adr);
		}
		catch(SQLException e) {
			e.printStackTrace();
			report="failed address insertion";
		}
		try {
			SQLInsert.newPayment(pmn);
		}
		catch(SQLException e) {
			e.printStackTrace();
			report="failed payment insertion";
		}try {
			SQLInsert.newProsthetics(prs);
		}
		catch(SQLException e) {
			e.printStackTrace();
			report="failed prosthetic insertion";
		}
		
		return(report);
	}
	public String[] getColours() {
		//returns tables, somehow we must extract from the tables to an array the colours.
		String[] colours = SQLSelect.getColours();
		if(colours!=null) {
			return(colours);
		}
		else {
			colours[0]= "none";
			return(colours);
		}
	}
	public String getStringThroughIndex(int index) {
		String colours []=SQLSelect.getColours();
		return(colours[index]);
	}
}