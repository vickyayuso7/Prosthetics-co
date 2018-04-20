package data_base.db.prostheticsJPA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import pojos.db.prosthetics.*;;

public class JPACreate {

	public static void main(String[] args)throws IOException{
		EntityManager user = Persistence.createEntityManagerFactory("user").createEntityManager();
		user.getTransaction().begin();
		user.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		user.getTransaction().commit();
		
		System.out.println("Please, input the user info:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Name: ");
		String name = reader.readLine();
		System.out.print("Password: ");
		String password = reader.readLine();
		
		User user1= new User(name, password);
		// Begin transaction 
				user.getTransaction().begin();
				// Store the object
				user.persist(user1);
				// End transaction
				user.getTransaction().commit();
				
				// Close the entity manager
				user.close(); 
		
	
		EntityManager priviledge = Persistence.createEntityManagerFactory("priviledge").createEntityManager();
		priviledge.getTransaction().begin();
		priviledge.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		priviledge.getTransaction().commit();
		
		System.out.println("Please, input the user info:");
		
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
		
	}
}
