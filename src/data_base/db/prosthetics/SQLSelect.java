package data_base.db.prosthetics;

import  java.sql.*;
import pojos.db.*;
import pojos.db.prosthetics.*;

import java.util.ArrayList;
import java.util.List;

public class SQLSelect{
	private static Connection c;
	private static List <String> colours;
	
	
	public static void  ShowAddress() throws SQLException{
		
		Connection c = SQLConnect.getConnection();
		
		String sql = "SELECT * FROM address join clients on id = sdt";

		Statement statement = c.prepareStatement(sql);
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			
			int id = rs.getInt("id");
			String country = rs.getString("country");
			int postCode = rs.getInt("postCode");
			String street = rs.getString("street");
			String town = rs.getString("town");
			int number = rs.getInt("number");
			String city = rs.getString("city");

			
			Address addition =new Address();
			addition.setCity(city);
			
			//Client client = new Client(client.setAddress(address),client.setDateOfBirth(dateOfBirth),client.setGender(gender),client.setId(id),
					//client.setName(name),client.setProsthetics(prosthetics));
			
		}
		rs.close();
		
	}


	public static ArrayList<String>  getColours() throws SQLException{
		String colour="";
		colours=new ArrayList<String>();
		String Query="SELECT DISTINCT color FROM Prosthetics;";
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs=stm1.executeQuery(Query);
		stm1.close();
		while(rs.next()) {
			colour= rs.getString("color");
			System.out.println(colour);
			colours.add(colour);
		}
		rs.close();
		return (ArrayList<String>) (colours);
	}
	
	public static ArrayList<String> getPaymentId() throws SQLException{
		String id;
		String Query="SELECT id FROM Payment;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getInt("id");
			idlist.add(id);
		}		
		return(idlist);
		
	}
	
	public static ArrayList<String> getMaterialId() throws SQLException{
		String id;
		String Query="SELECT id FROM Material;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getInt("id");
			idlist.add(id);
		}		
		return(idlist);
		
	}
	
	
	public static ArrayList<String> getProstheticId() throws SQLException{
		String id;
		String Query="SELECT id FROM Prosthetics;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getInt("id");
			idlist.add(id);
		}		
		return(idlist);
	}
	
	
	public static ArrayList<String> getClientId() throws SQLException{
		String id;
		String Query="SELECT id FROM Client;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getInt("id");
			idlist.add(id);
		}		
		return(idlist);
		
	}
	public static ArrayList<String> getClientNames() throws SQLException{
		String id;
		String Query="SELECT name FROM Client;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getString("name");
			idlist.add(id);
		}		
		return(idlist);
		
	}
	
	public static ArrayList<String> getAddressId() throws SQLException{
		String id;
		String Query="SELECT id FROM Address;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getInt("id");
			idlist.add(id);
		}		
		return(idlist);
		
	}
		
	
	public static ArrayList<String> getFeaturesId() throws SQLException{
		String id;
		String Query="SELECT id FROM Features;";
		ArrayList <String> idlist= new <String> ArrayList();
		Statement stm1 = SQLConnect.getConnection().createStatement();
		ResultSet rs= stm1.executeQuery(Query);
		while (rs.next()) {
			id=""+rs.getInt("id");
			idlist.add(id);
		}		
		return(idlist);
	}
//SELECT * features (asking for id)
	public static Features getFeaturesThroughId(int id) throws SQLException{
		String Query="SELECT * FROM Features WHERE id = ?;";
		Features feature=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, id);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			float price = rs.getFloat("best_price");
			String style= rs.getString("style");
			boolean enhanced= rs.getBoolean("enhanced_movement");
			boolean sensibility =rs.getBoolean("sensibility");
			int idp = rs.getInt("id");
			feature=new Features(idp, price, style, sensibility, enhanced);
		}
		return(feature);
	}
	//SELECT * features ( not asking for id)
		public static Features getFeatures() throws SQLException{
			String Query="SELECT * FROM Features;";
			Features feature=null;
			PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
			ResultSet rs = stm1.executeQuery();
			while(rs.next()) {
				float price = rs.getFloat("best_price");
				String style= rs.getString("style");
				boolean enhanced= rs.getBoolean("enhanced_movement");
				boolean sensibility =rs.getBoolean("sensibility");
				int idp = rs.getInt("id");
				feature=new Features(idp, price, style, sensibility, enhanced);
			}
			return(feature);
		}
	
	//	II) SELECT * FROM prosthetics ORDER BY typeOfAmputation DESC; 
	
	public static Prosthetics getProsthetics() throws SQLException{
		String Query="SELECT * FROM prosthetics ORDER BY type_of_amputation;";
		Prosthetics prosthetic=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			float size = rs.getFloat("size");
			float weight = rs.getFloat("weight");
			String type_of_funcionality= rs.getString("type_of_funcionality");
			String type_of_amputation= rs.getString("type_of_amputation");
			System.out.println(type_of_amputation+"it is I Bendthatdiccuminbich but you can call me benefitial cucumber, what a pleasure is to meet you and so forth.");
			String color = rs.getString("color");
			float bestPrice = rs.getFloat("bestPrice");
			//Payment payment = rs.getPayment("payment");
			int id = rs.getInt("id");
			prosthetic=new Prosthetics(id, size, weight, type_of_funcionality, type_of_amputation,color,bestPrice);
		}
		return(prosthetic);
	}
	
//SELECT * FROM prosthetics (asking for i)
	
	public static Prosthetics getProstheticThroughId(int id) throws SQLException{
		String Query="SELECT * FROM prosthetics WHERE id = ?;";
		Prosthetics prosthetic=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, id);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			float size = rs.getFloat("size");
			float weight = rs.getFloat("weight");
			String type_of_funcionality= rs.getString("type_of_functionality");
			String type_of_amputation= rs.getString("type_of_amputation");
			String color = rs.getString("color");
			float bestPrice = rs.getFloat("bestPrice");
			//Payment payment = rs.getPayment("payment");
			int idp = rs.getInt("id");
			prosthetic=new Prosthetics(id, size, weight, type_of_funcionality, type_of_amputation,color,bestPrice);
		}
		return(prosthetic);
	}
	
	//SELECT * FROM FEATURE (asking for id)
	public static Features getFeatureThroughId(int id) throws SQLException{
		String Query="SELECT * FROM Features WHERE id = ?;";
		Features feature=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, id);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			float price = rs.getFloat("best_price");
			String style= rs.getString("style");
			boolean enhanced= rs.getBoolean("enhanced_movement");
			boolean sensibility =rs.getBoolean("sensibility");
			int idp = rs.getInt("id");
			feature=new Features(idp, price, style, sensibility, enhanced);
		}
		return(feature);
	}
	
	//SELECT * FROM FEATUREs (not asking for id)
	
	public static ArrayList<Features> getFeature() throws SQLException{
		ArrayList <Features> features =new ArrayList <Features>();
		String Query="SELECT * FROM Features;";
		Features feature=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			float price = rs.getFloat("best_price");
			String style= rs.getString("style");
			boolean enhanced= rs.getBoolean("enhanced_movement");
			boolean sensibility =rs.getBoolean("sensibility");
			int id = rs.getInt("id");
			feature=new Features(id, price, style, sensibility, enhanced);
		}
		features.add(feature);
		return(features);
	}
	
	
	
	//VI) SELECT * FROM client;(not asking for id)
	
	public static ArrayList<Client> getClient() throws SQLException{
		ArrayList <Client> clients =new ArrayList <Client>();
		String Query="SELECT * FROM client;";
		Client client=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			
			String name= rs.getString("name");
			Date date_of_birth = rs.getDate("date_of_birth");
			String gender = rs.getString("gender");
			int id = rs.getInt("id");
			client=new Client (id,date_of_birth,name,gender);
		}
		clients.add(client);
		return(clients);
	}
	
	
	//VI) SELECT * FROM client; (Asking for id)
	
	public static Client getClient(int id) throws SQLException{
		String Query="SELECT * FROM client WHERE id =? ;";
		Client client=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1,id);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			
			String name= rs.getString("name");
			Date date_of_birth = rs.getDate("date_of_birth");
			String gender = rs.getString("gender");
			int idp = rs.getInt("id");
			client=new Client (id,date_of_birth,name,gender);
		}
		return(client);
	}
	
	
	
	
	//IX) SELECT * FROM address;(asking for id)
	public static Address getAddress(int id) throws SQLException{
		String Query="SELECT * FROM address WHERE id = ?;";
		Address address=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1,id);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			
			String country= rs.getString("country");
			int postCode = rs.getInt("postCode");
			String street = rs.getString("street");
			String town = rs.getString("town");
			String city =rs.getString("city");
			int number=rs.getInt("number");
			int idp = rs.getInt("id");
			address=new Address (id,country, postCode,street, town,number,null, city);
		}
		return(address);
	}
	
	//IX) SELECT * FROM address;(not asking for id)
	public static ArrayList<Address> getAddress() throws SQLException{
		ArrayList <Address> addresses =new ArrayList <Address>();
		String Query="SELECT * FROM address;";
		Address address=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			
			String country= rs.getString("country");
			int postCode = rs.getInt("postCode");
			String street = rs.getString("street");
			String town = rs.getString("town");
			int number=rs.getInt("number");
			int id = rs.getInt("id");
			address=new Address (id,country, postCode,street, town,number);
		}
		addresses.add(address);
		return(addresses);
	}
	//VIII) SELECT city, town, country FROM address WHERE country <> 'Spain' ORDER BY 3 DESC;
	
	public static ArrayList<Address> getFromAddress() throws SQLException{
		ArrayList <Address> addresses =new ArrayList <Address>();
		String Query="SELECT city, town, country FROM address WHERE country <> 'Spain' ORDER BY 3 DESC;";
		Address address=null;
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			
			String country= rs.getString("country");
			
			String town = rs.getString("town");
			String city=rs.getString("city");
			int id = rs.getInt("id");
			address=new Address (id,country,town,city);
		}
		addresses.add(address);
		return(addresses);
	}
	//getProstheticIdThruClientId
	public static ArrayList<String> getProstheticIdThruClientId(int ids) throws SQLException{
		String id;
		String Query="SELECT prosthetic_id FROM Client_Prosthetics WHERE client_id = ?;";
		ArrayList <String> idlist= new <String> ArrayList();
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, ids);
		ResultSet rs= stm1.executeQuery();
		while (rs.next()) {
			id=""+rs.getInt("prosthetic_id");
			idlist.add(id);
		}
		rs.close();
		stm1.close();
		return(idlist);
		
	}
	public static Material getMaterial(int id) throws SQLException{
		Material mat;
		String Query = "SELECT * FROM Material WHERE id = ?";
		PreparedStatement stm1 =SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, id);
		ResultSet rs = stm1.executeQuery();
		int ids=-1;
		String style="";
		String provider="";
		float price=-1;
		while(rs.next()) {
			ids =rs.getInt("id");
			style = rs.getString("type");
			provider =rs.getString("provider");
			price =rs.getFloat("priceModifier");
		}
		mat =new Material(ids, price, provider, style);
		return(mat);
		
	}

	public static int getAddressIdThroughClientId(int id) throws SQLException{
		String Query= "SELECT address_id FROM Client WHERE id =?";
		PreparedStatement stm1 =SQLConnect.getConnection().prepareStatement(Query);		
		stm1.setInt(1, id);
		ResultSet rs =stm1.executeQuery();
		int ids=-1;
		while (rs.next()) {
			ids=rs.getInt("address_id");
		}
		return(ids);
	}

	public static int getPaymentIdThruProstheticId(int prostheticId) throws SQLException {
		String Query= "SELECT payment_id FROM Prosthetics WHERE id =?";
		PreparedStatement stm1 =SQLConnect.getConnection().prepareStatement(Query);		
		stm1.setInt(1, prostheticId);
		ResultSet rs =stm1.executeQuery();
		int ids=-1;
		while (rs.next()) {
			ids=rs.getInt("payment_id");
		}
		return(ids);
		
	}

	public static Payment getPayment(int paymentId) throws SQLException {
		String Query = "SELECT * FROM Payments WHERE id =?";
		PreparedStatement stm1 =SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, paymentId);
		ResultSet rs=stm1.executeQuery();
		Payment pmn =new Payment();
		while(rs.next()) {
			int id =rs.getInt("id");
			Date deadline = rs.getDate("deadline");
			int iban =rs.getInt("iban");
			String method =rs.getString("method");
			pmn.setDeadline(deadline);
			pmn.setIban(iban);
			pmn.setId(id);
			pmn.setMethod(method);
		}
		return(pmn);
	}


	public static int[] getClientIdthrouName(String name) throws SQLException{
		ArrayList <String> names =new ArrayList <String>();
		String Query="SELECT id FROM client WHERE name = ?;";
		PreparedStatement stm1 = SQLConnect.getConnection().prepareStatement(Query);
		stm1.setString(1, name);
		ResultSet rs = stm1.executeQuery();
		while(rs.next()) {
			names.add(rs.getString("id"));
		}
		String[]arrayNames = names.toArray(new String[1]);
		int[]id =new int[arrayNames.length];
		for (int i = 0; i < id.length; i++) {
			id[i] =Integer.parseInt(arrayNames[i]);
		}
		return(id);
	}
	
	public static int getMaterialIdthruProstheticId(int id) throws SQLException{
		int matId=-1;
		String Query="SELECT material_id FROM Material_Prosthetics WHERE prosthetic_id =?";
		PreparedStatement stm1 =SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, id);
		ResultSet rs= stm1.executeQuery();
		while(rs.next()) {
			matId=rs.getInt("material_id");
		}
		return(matId);
	}
	//SELECT * payment (not asking for id)
	//SELECT * MATERIAL (not asking for id)


	public static int getFeatureIdthruProstheticId(int prsId) throws SQLException{
		int featId=-1;
		String Query="SELECT features_id FROM Features_Prosthetics WHERE prosthetic_id =?";
		PreparedStatement stm1 =SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, prsId);
		ResultSet rs= stm1.executeQuery();
		while(rs.next()) {
			featId=rs.getInt("features_id");
		}
		return(featId);
	}


	public static float getFullPrice(int prostheticId) {
		//String Query ="SELECT priceModifier + best_price + bestPrice FROM Material AS mat JOIN Features AS feat JOIN Prosthetics AS prs WHERE mat.id = "
		return(0);
	}


	public static int getProstheticIdThruPaymentId(int parseInt) throws SQLException{
		int featId=-1;
		String Query="SELECT id FROM Prosthetics WHERE payment_id =?";
		PreparedStatement stm1 =SQLConnect.getConnection().prepareStatement(Query);
		stm1.setInt(1, parseInt);
		ResultSet rs= stm1.executeQuery();
		while(rs.next()) {
			featId=rs.getInt("id");
		}
		return(featId);
	}
	
	
	
	
	

}
