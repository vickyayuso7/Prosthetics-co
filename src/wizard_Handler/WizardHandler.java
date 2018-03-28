package wizard_Handler;
import java.sql.SQLException;
import java.util.ArrayList;

import data_base.db.prosthetics.*;
import pojos.db.prosthetics.*;
public class WizardHandler{


	public WizardHandler(){
		SQLConnect.establishConnection();
	}	
	public String newClient(Client cln, Address adr, Payment pmn, Prosthetics prs, int featureId, int materialId) {
		String report="all clear";
		int idAddress=-1;
		int idPayment=-1;
		int idClient=-1;
		int idProsthetic=-1;
		try {
			idAddress=SQLInsert.newAddress(adr);
		}
		catch(SQLException e) {
			e.printStackTrace();
			report="failed address insertion";
		}
		try {
			idClient=SQLInsert.newClient(cln,idAddress);
		} catch (SQLException e) {
			e.printStackTrace();
			report="failed client insertion";
		}
		try {
			idPayment=SQLInsert.newPayment(pmn);
		}
		catch(SQLException e) {
			e.printStackTrace();
			report="failed payment insertion";
		}try {
			//ask how to get last added id
			idProsthetic=SQLInsert.newProsthetics(prs,idPayment);
		}
		catch(SQLException e) {
			e.printStackTrace();
			report="failed prosthetic insertion";
		}
		try {
			SQLInsert.newClient_Prosthetics(idClient, idProsthetic);
			SQLInsert.newMaterial_Prosthetics(materialId, idProsthetic);
			SQLInsert.newFeatures_Prosthetics(featureId, idProsthetic);
		}
		catch(Exception sq) {
			sq.printStackTrace();
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
	public String[] getClientId(){
		try {
			String [] id = new String[1];
			id= SQLSelect.getClientId().toArray(id);
			return(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return(null);
		}
		
	}	
	public String[] getClientNames(){
		try {
			String [] id = new String[1];
			id= SQLSelect.getClientNames().toArray(id);
			return(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return(null);
		}
	}
	public String[] magicConversionProstheticsThrouClient (int id) {
		try {
			String [] Prosthetics =new String[1];
			Prosthetics=SQLSelect.getProstheticIdThruClientId(id).toArray(Prosthetics);
			return(Prosthetics);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return (null);
		}
	}
	public String[] getMaterialId() {
		String[] id = new String[1];
		try {
			id=SQLSelect.getMaterialId().toArray(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(id);
	}
	public Material getMaterialFull(int id) {
		return (SQLSelect.getMaterial(id));
	}

}