package data_base.db.prostheticsJPA;

import java.util.List;
import java.io.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pojos.db.prosthetics.Privilege;
import pojos.db.prosthetics.User;

public class JPADelete {
	public static boolean deleteUser(User user) throws Exception {
		Query q1 = JPAConnect.getEntityManager().createNativeQuery("SELECT * FROM user", User.class);
		List<User> userList = (List<User>) q1.getResultList();
		if (userList.remove(user)) {
			return true;

		} else {

			return false;

		}

	}

	public static boolean deletePrivilege(Privilege privilege) throws Exception {
		Query q1 = JPAConnect.getEntityManager().createNativeQuery("SELECT * FROM privilege", Privilege.class);
		List<Privilege> privilegeList = (List<Privilege>) q1.getResultList();

		if (privilegeList.remove(privilege)) {

			return true;
		} else {
			return false;
		}

	}

}