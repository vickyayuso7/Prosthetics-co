package data_base.db.prostheticsJPA;

import java.util.ArrayList;
import java.util.List;

import java.io.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pojos.db.prosthetics.Privilege;
import pojos.db.prosthetics.User;

public class JPARead {
	
	public static List<User> readUser() throws Exception{
		Query q1 = JPAConnect.getEntityManager().createNativeQuery("SELECT * FROM users", User.class);
		List<User> user = (List<User>) q1.getResultList();
		System.out.println(user);
		return user;
	}
	public static List<Privilege> readPrivilege() throws Exception{
		Query q1 = JPAConnect.getEntityManager().createNativeQuery("SELECT * FROM userType", Privilege.class);
		List<Privilege> privilege = (List<Privilege>) q1.getResultList();
		return privilege;
	}
	public static Privilege getStatus(int level) throws Exception{
		Query q1 =JPAConnect.getEntityManager().createNativeQuery("SELECT * FROM userType WHERE Privilege = ?", Privilege.class);
		q1.setParameter(1, level);
		Privilege pr=(Privilege)q1.getSingleResult();
		return pr;
	}
}
