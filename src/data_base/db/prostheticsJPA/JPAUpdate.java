package data_base.db.prostheticsJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pojos.db.prosthetics.User;


public class JPAUpdate {

private static EntityManager user;
	
	private static void printDepartments() {
		Query q1 = user.createNativeQuery("SELECT * FROM users", User.class);
		
	}
}
