package data_base.db.prostheticsJPA;

import java.util.List;
import java.io.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pojos.db.prosthetics.User;

public class JPADelete {
	private static EntityManager connection;

	
		
	private static void printUser() {
		Query q1 = connection.createNativeQuery("SELECT * FROM User", User.class);
		List<User> users = (List<User>) q1.getResultList();
		for (User tempUser : users ) {
			System.out.println(tempUser);
		}
	

	System.out.println("List of users:");
	printUser();
	System.out.print("Choose a user you want to delete:");
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	int user_id=0;
	try {
		user_id = Integer.parseInt(reader.readLine());
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Query q2 = connection.createNativeQuery("SELECT * FROM users WHERE id = ?", User.class);
	q2.setParameter(1, user_id);
	User userDeleted = (User) q2.getSingleResult();

	// Begin transaction
	connection.getTransaction().begin();
	// Store the object
	connection.remove(userDeleted);
	// End transaction
	connection.getTransaction().commit();

	// Close the entity manager
	connection.close();
	}
}