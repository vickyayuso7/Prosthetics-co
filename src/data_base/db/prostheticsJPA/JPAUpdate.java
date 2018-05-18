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
	
	public static void EditUser(User user) throws Exception {
	
		Query q1 = JPAConnect.getEntityManager().createNativeQuery("SELECT * FROM users WHERE id=?", User.class);
		q1.setParameter(1, user.getId());
		User user1 = (User) q1.getSingleResult();
		JPAConnect.getEntityManager().getTransaction().begin();
		user1=user;
		JPAConnect.getEntityManager().getTransaction().commit();
	}
	public static void EditPrivilege(Privilege privilege) throws Exception {
		
		Query q1 = JPAConnect.getEntityManager().createNativeQuery("SELECT * FROM UserType WHERE id=?", Privilege.class);
		q1.setParameter(1, privilege.getId());
		Privilege privilege1 = (Privilege) q1.getSingleResult();
		JPAConnect.getEntityManager().getTransaction().begin();
		privilege1=privilege;
		JPAConnect.getEntityManager().getTransaction().commit();
	}
}

 