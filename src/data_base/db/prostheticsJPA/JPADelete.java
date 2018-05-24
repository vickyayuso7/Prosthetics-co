package data_base.db.prostheticsJPA;

import java.util.List;
import java.io.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pojos.db.prosthetics.Privilege;
import pojos.db.prosthetics.User;

public class JPADelete {
	public static void deleteUser(User user) throws Exception {
		JPAConnect.getEntityManager().getTransaction().begin();
		JPAConnect.getEntityManager().remove(user);
		System.out.println("paso por delete");
		JPAConnect.getEntityManager().getTransaction().commit();
	}
	public static void deletePrivilege(Privilege privilege) throws Exception {
		JPAConnect.getEntityManager().getTransaction().begin();
		JPAConnect.getEntityManager().remove(privilege);
		JPAConnect.getEntityManager().getTransaction().commit();
	}
}