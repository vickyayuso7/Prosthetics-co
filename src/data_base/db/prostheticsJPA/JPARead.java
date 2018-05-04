package data_base.db.prostheticsJPA;

import java.util.List;

import java.io.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pojos.db.prosthetics.User;

public class JPARead {

	public static EntityManager connection;

	private static void readUser() {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Write the department's name: ");
		String name = null;
		try {
			name = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Matching departments:");
		Query q1 = connection.createNamedQuery("SELECT * FROM users WHERE id = ?", User.class);

		q1.setParameter(1, "%" + name + "%");
		List<User> user = (List<User>) q1.getResultList(); // a list of the objects we put here
		// Print the departments
		for (User user1 : user) {
			System.out.println(user1);
		}

		System.out.print("Write the user's ID: ");
		int user_id;
		try {
			user_id = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Query q2 = connection.createNativeQuery("SELECT * FROM users WHERE id = ?", User.class);// we pass the type of
																								// object we are gonna
																								// retrieve
		q2.setParameter(1, name);// fill the question mark
		User paco = (User) q2.getSingleResult();// only call if we are totally sure we are getting a single result
		// Print the department
		System.out.println(paco);

		// Close the entity manager
		connection.close();

	}
}
