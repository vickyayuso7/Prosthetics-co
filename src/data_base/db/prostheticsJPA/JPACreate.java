package data_base.db.prostheticsJPA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import pojos.db.prosthetics.*;;

public class JPACreate {

	public static void create (User user1)throws IOException{
		EntityManager manager = Persistence.createEntityManagerFactory("manager").createEntityManager();
		manager.getTransaction().begin();
		manager.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		manager.getTransaction().commit();
		
		//-----------------
		// Begin transaction 
				manager.getTransaction().begin();
				// Store the object
				manager.persist(user1);
				// End transaction
				manager.getTransaction().commit();
				
		
	
		manager.getTransaction().begin();
		manager.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		/*System.out.println("Please, input the user info:");
		
		System.out.print("Option: ");
		String option = reader.readLine();
		
		
		User user2= new User(name, password);
		// Begin transaction 
				priviledge.getTransaction().begin();
				// Store the object
				priviledge.persist(user1);
				// End transaction
				priviledge.getTransaction().commit();
				
				// Close the entity manager
				priviledge.close(); 
	*/	
	}
	
	public static void create2 (Privilege privilege)throws IOException{
		EntityManager manager = Persistence.createEntityManagerFactory("manager").createEntityManager();
		manager.getTransaction().begin();
		manager.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		manager.getTransaction().commit();
		
		//-----------------
		// Begin transaction 
				manager.getTransaction().begin();
				// Store the object
				manager.persist(privilege);
				// End transaction
				manager.getTransaction().commit();
				
		
	
		manager.getTransaction().begin();
		manager.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		/*System.out.println("Please, input the user info:");
		
		System.out.print("Option: ");
		String option = reader.readLine();
		
		
		User user2= new User(name, password);
		// Begin transaction 
				priviledge.getTransaction().begin();
				// Store the object
				priviledge.persist(user1);
				// End transaction
				priviledge.getTransaction().commit();
				
				// Close the entity manager
				priviledge.close(); 
	*/	
	}
	
	//public static void main(String []args) throws IOException {
//System.out.println("Please, input the user info:");
		
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		/*System.out.print("Name: ");
		String name = reader.readLine();
		System.out.print("Password: ");
		String password = reader.readLine();
		System.out.println("Privilege??");
		String option= reader.readLine();*/
		int status;
		switch(Integer.parseInt(option)){
		case 1:
			status=0;
			break;
		
		case 2:
			status=1;
			break;
			
		case 3:
			
			status=2;
			break;
		}
		if(option.equals("yes")) {
			Privilege privilege= new Privilege(Integer.parseInt(option));
			create2(privilege);
		}
		else {
		User user1= new User(name, password);
		
		create(user1);
	}
}
}