package wizard_Handler;
import java.sql.SQLException;
import java.util.ArrayList;

import data_base.db.prosthetics.*;
import pojos.db.prosthetics.*;
public class WizardHandler{
SQLConnect thisIsYourFaultRodrigoDamnYou=new SQLConnect();
private int admin;
private int UserId;

	public WizardHandler(){
		thisIsYourFaultRodrigoDamnYou.establishConnection();
	}
	public void setAdmin(int admin) {
		this.admin=admin;
	}
	public int getAdmin() {
		return this.admin;
	}
	public int getUserId() {
		return this.UserId;
	}
	public void setUserId(int userId) {
		this.UserId=userId;
	}
	public int getUserIdThruClientId(int id) {
		try {
			return(SQLSelect.getUserIdThruClientId(id));
		}catch(Exception ex) {
			return -1;
		}
	}
	public String newClient(Client cln, Address adr, Payment pmn, Prosthetics prs, int featureId, int materialId) {
		String report="all clear";
		int idAddress=-1;
		int idPayment=-1;
		int idClient=-1;
		int idProsthetic=-1;
		try {
			System.out.println(adr.getCountry()+"\n"+adr.getCity()+"\n"+adr.getTown()+"\n"+adr.getStreet()+"\n"+adr.getNumber()+"\n"+adr.getPostCode());
			idAddress=SQLInsert.newAddress(adr);
		}
		catch(SQLException e) {
			e.printStackTrace();
			report="failed address insertion";
		}
		///
		try {
			cln.setUserId(this.getUserId());
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
				for (int i = 0; i < humanfailure.length; i++) {
					if(humanfailure[i]==null) {
						humanfailure[i]="the world is bleak and colourless";
					}
				}
				
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
	///
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
	///
	public void appClosed() {
		thisIsYourFaultRodrigoDamnYou.closeConnection();
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
			id[0]="error";
		}
		return(id);
	}
	//retourned obj
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
	//update user
	public String editFeature(Features feat) {
		String report="";
		try {
			//System.out.println(feat.getStyle());
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
		try {
			return (SQLSelect.getMaterial(id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return(null);
		}
	}
	public Client getClientFull(int id) {
		try {
			return(SQLSelect.getClient(id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int getAddressIdThruClientId(int id) {
		try {
			int ids=SQLSelect.getAddressIdThroughClientId(id);
			return(ids);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return(-1);
		}
	}
	public Address getAddressFull(int addressId) {
		try {
			return(SQLSelect.getAddress(addressId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return(null);
		}
	}
	public int getProstheticIdThruClientId(int clientId) {
		try {
			String[] id =new String[1];
			id =SQLSelect.getProstheticIdThruClientId(clientId).toArray(id);
			int ids=0;
			for (int i = 0; i < id.length; i++) {
				System.out.println(id[i]);
				ids = Integer.parseInt(id[i]);
			}
			return(ids);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return(-1);
		}
	}
	public Prosthetics getProstheticFull(int prostheticId) {
		try {
			return(SQLSelect.getProstheticThroughId(prostheticId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return(null);
		}
		
	}
	public int getPaymentIdThruProstheticId(int prostheticId) {
		try {
			return(SQLSelect.getPaymentIdThruProstheticId(prostheticId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return(-1);
		}
	}
	public Payment getPaymentFull(int paymentId) {
		try {
			return(SQLSelect.getPayment(paymentId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public String editClient(Client cln, Address adr, Prosthetics prs, Payment pmn) {
		try {
			SQLUpdate.updateClient(cln);
			SQLUpdate.updateAddress(adr);
			SQLUpdate.updateProsthetics(prs);
			SQLUpdate.updatePayment(pmn);
			return ("all clear");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("throw me a plugged toaster while i bathe in my tears");
			return("Just fucking kill me already");
		}
		
	}
		
	public int[] getClientIdThrouName(String name) {
		try {
			int[]id = SQLSelect.getClientIdthrouName(name);
			return(id);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return(null);
		}
	}
	public String EditMaterial(Material mat) {
		String report ="";
		try {
			SQLUpdate.updateMaterial(mat);
			report="success";
		}
		catch(Exception ex) {
			report="failed";
		}
		return report;
	}
	public String newProsthetic(Prosthetics prs,Material mat, Features feat, Payment pmn,int clnID) {
		String report="failed";
		int idpay;
		int idprs;
		try {
			idpay=SQLInsert.newPayment(pmn);
			idprs=SQLInsert.newProsthetics(prs, idpay);
			SQLInsert.newClient_Prosthetics(clnID, idprs);
			SQLInsert.newFeatures_Prosthetics(feat.getId(), idprs);
			SQLInsert.newMaterial_Prosthetics(mat.getId(), idprs);
			report="success";
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return report;
	}
	public int  getMaterialidThrouProstheticId(int prsId) {
		int id=-1;
		try {
			id= SQLSelect.getMaterialIdthruProstheticId(prsId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(id);
	}
	public int  getFeatureidThrouProstheticId(int prsId) {
		int id=-1;
		try {
			id= SQLSelect.getFeatureIdthruProstheticId(prsId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(id);
	}
	public float getFullPrice(int prostheticId) {
		int id=0;
		try {
			SQLSelect.getFullPrice(prostheticId);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	public String[] getProstheticsId() {
		try {
			String[] id=SQLSelect.getProstheticId().toArray(new String[1]);
			return(id);
		}catch(Exception ex) {
			ex.printStackTrace();
			return(null);
		}
	}
	public int getProstheticIdThruPaymentId(int parseInt) {
		int id;
		try {
			id = SQLSelect.getProstheticIdThruPaymentId(parseInt);
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return(0);
		}
		
	}
	public String[] getCountriesOrdered() {
		
		try {
			return SQLSelect.getCountriesOrdered();
		} catch (SQLException e) {
			e.printStackTrace();
			return(null);
		}
	}
	public String[] getCitiesOrdered() {
		
		try {
			return SQLSelect.getCitiesOrdered();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public String[] getStreetsOrdered() {
		
		try {
			return SQLSelect.getStreetsOrdered();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public String[] getNamesOrdered() {
		
		try {
			return SQLSelect.getNamesOrdered();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	//
	public String deleteProsthetic(Prosthetics prostheticFull) {
		try {
			SQLDelete.deleteProsthetic(prostheticFull);
			return("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return("failure");
		}
	}
	
}