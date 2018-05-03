package data_base.db.prostheticsJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import pojos.db.prosthetics.User;


public class JPAUpdate {

private static EntityManager connection;
	
	private static void printUsers() throws NumberFormatException, IOException {
		Query q1 = connection.createNativeQuery("SELECT * FROM users", User.class);
		List<User> users = (List<User>) q1.getResultList();
		for (User user : users) {
			System.out.println(user);
		}
	}

	
		
		//JPAConnect connection= new JPAConnect();
		//connection.establishConnection();
		
		/*connection = Persistence.createEntityManagerFactory("user").createEntityManager();
		connection.getTransaction().begin();
		connection.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		connection.getTransaction().commit();*/

		
		System.out.println("Users' names:");
		printUsers();
		System.out.print("Type a name to change its password:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int user_id = Integer.parseInt(reader.readLine());
		Query q2 = JPAConnect.getEntityManager().createNativeQuery("SELECT * FROM users WHERE id = ?", User.class);
		q1.setParameter(1, user_id);
		User user = (User) q1.getSingleResult();
		System.out.print("Type a new password:");
		String newPassword = reader.readLine();
		
		JPAConnect.getEntityManager().getTransaction().begin();
		user.setPassword(newPassword);
		JPAConnect.getEntityManager().getTransaction().commit();
		
	
		JPAConnect.getEntityManager().close();
	}
}


 