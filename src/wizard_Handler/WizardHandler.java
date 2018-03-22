package wizard_Handler;
import java.sql.SQLException;
import java.util.ArrayList;

import data_base.db.prosthetics.*;
import pojos.db.prosthetics.*;
public class WizardHandler{


	public WizardHandler(){
		SQLConnect.establishConnection();
	}	
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

		ArrayList <String> colours;
		String[] humanfailure;

		try {
			colours = SQLSelect.getColours();
			if(colours.isEmpty()) {
				humanfailure=new String[1];
				humanfailure[0]="none";
				return(humanfailure);
			}
			else {
				humanfailure =colours.toArray(new String[0]);
				return(humanfailure);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return(null);
		}	
	}
	public String getStringThroughIndex(int index) {
		ArrayList<String> colours;
		String[] colourIndex;
		try {
			colours = SQLSelect.getColours();
			colourIndex=colours.toArray(new String[1]);
			return(colourIndex[index]);
		} catch (SQLException e) {
			e.printStackTrace();
			return("none");
		}

	}
	public String createTables() {
		try {
			SQLCreate.Create(SQLConnect.getConnection());
			return("Success");
		}
		catch(Exception ex){
			ex.printStackTrace();
			return("Failed");
		}
	}
	public void appClosed() {
		SQLConnect.closeConnection();
	}
	public String reloadTables() {
		try {
			SQLCreate.deleteDatabase(SQLConnect.getConnection());
			SQLCreate.Create(SQLConnect.getConnection());
			return("success");
		} catch (Exception e) {
			e.printStackTrace();
			return("failed");
		}
	}
	public void deleteTables() {
		try {
			SQLCreate.deleteDatabase(SQLConnect.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String newFeature(Features feat) {
		try {
			SQLInsert.newFeatures(feat);
			return("success");
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return("failed");
		}
	}
	public String newMaterial(Material mat) {
		String report="";
		try {
			SQLInsert.newMaterial(mat);
			report="success";
		}
		catch(Exception ex) {
			report="failure";
		}
		return(report);
	}
	public String[] getFeatureId() {
		String[] id= new String [1];
		try {
			ArrayList <String> list = SQLSelect.getFeaturesId();
			id=list.toArray(id);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			id[1]="error";
		}
		return(id);
	}
	public Features getFeatureFull(int id) {
		Features feature=null;
		try {
			feature = SQLSelect.getFeatureThroughId(id);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return(feature);
	}
	public String editFeature(Features feat) {
		String report="";
		try {
			SQLUpdate.updateFeatures(feat);
			report="success";
		}
		catch(Exception ex) {
			report="failed";
			ex.printStackTrace();
		}
		return(report);
	}
}