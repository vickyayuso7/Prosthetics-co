package data_base.db.prostheticsJPA;

import java.util.List;
import java.io.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pojos.db.prosthetics.Privilege;
import pojos.db.prosthetics.User;

public class JPADelete {
	public static void deleteUser(User user) throws Exception {
		Query q1=JPAConnect.getEntityManager().createNativeQuery("SELECT * FROM user WHERE id =?");
		q1.setParameter(1, user.getId());
		user=(User) q1.getSingleResult();
		JPAConnect.getEntityManager().getTransaction().begin();
		JPAConnect.getEntityManager().remove(user);
		JPAConnect.getEntityManager().getTransaction().commit();
	}
	public static void deletePrivilege(Privilege privilege) throws Exception {
		Query q1 = JPAConnect.getEntityManager().createNativeQuery("SELECT * FROM privilege WHERE id=?", Privilege.class);
		q1.setParameter(1, privilege.getId());
		privilege=(Privilege) q1.getSingleResult();
		JPAConnect.getEntityManager().getTransaction().begin();
		JPAConnect.getEntityManager().remove(privilege);
		JPAConnect.getEntityManager().getTransaction().commit();
	}
}