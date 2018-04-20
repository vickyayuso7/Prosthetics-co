package data_base.db.prostheticsJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pojos.db.prosthetics.User;


public class JPADelete {
	private static EntityManager user;

	private static void printEmployees() {
		Query q2 = user.createNativeQuery("SELECT * FROM User", User.class);
		
	}
}
