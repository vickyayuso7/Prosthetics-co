package data_base.db.prostheticsJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import pojos.db.prosthetics.Privilege;
import pojos.db.prosthetics.User;


public class JPAUpdate {
	
	public static void EditUser(User user, String name) throws Exception {
	
		Query q1 = JPAConnect.getEntityManager().createNativeQuery("SELECT * FROM users", User.class);
		List<User> users = (List<User>) q1.getResultList();

		q1.setParameter(1, "%" + name + "%");
		user = (User) q1.getSingleResult();
		
	}
	public static void EditPrivilege(Privilege privilege, int option) throws Exception {
		
		Query q1 = JPAConnect.getEntityManager().createNativeQuery("SELECT * FROM privilege", User.class);
		List<Privilege> privileges = (List<Privilege>) q1.getResultList();

		q1.setParameter(1, "%" + option + "%");
		privilege = (Privilege) q1.getSingleResult();
		
	}
}

 