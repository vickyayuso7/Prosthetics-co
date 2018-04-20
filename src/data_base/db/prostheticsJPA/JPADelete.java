package data_base.db.prostheticsJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pojos.db.prosthetics.User;


public class JPADelete {
	private static EntityManager manager;

	private static void printUser() {
		Query q1 = manager.createNativeQuery("SELECT * FROM User", User.class);
		List<User> users = (List<User>) q1.getResultList();
		for (User tempUser : users ) {
			System.out.println(tempUser);
		}
	}
	public static void main(String[] args){
		printUser();
		
	}
}
