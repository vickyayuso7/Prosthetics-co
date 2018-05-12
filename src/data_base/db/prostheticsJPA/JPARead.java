package data_base.db.prostheticsJPA;

import java.util.ArrayList;
import java.util.List;

import java.io.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pojos.db.prosthetics.Privilege;
import pojos.db.prosthetics.User;

public class JPARead {

	public User getUsers(User user){
		return user;
		
	}
	public static List<User> readUser() throws Exception{

		String name = null;
		
		Query q1 = JPAConnect.getEntityManager().createNamedQuery("SELECT * FROM user", User.class);

		q1.setParameter(1, "%" + name + "%");
		List<User> user = (List<User>) q1.getResultList(); // a list of the
															// objects we put
															// here		
	
		return user;

	}
	public static List<Privilege> readPrivilege() throws Exception{

		String name = null;
		
		Query q1 = JPAConnect.getEntityManager().createNamedQuery("SELECT * FROM privilege", User.class);

		q1.setParameter(1, "%" + name + "%");
		List<Privilege> privilege = (List<Privilege>) q1.getResultList(); // a list of the
															// objects we put
															// here		
	
		return privilege;

	}
}
