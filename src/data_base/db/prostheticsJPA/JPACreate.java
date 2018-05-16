package data_base.db.prostheticsJPA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import pojos.db.prosthetics.*;;

public class JPACreate {

	public static User createUser (User user1)throws Exception{ 
				JPAConnect.getEntityManager().getTransaction().begin();
				JPAConnect.getEntityManager().persist(user1);
				JPAConnect.getEntityManager().getTransaction().commit();
				System.out.println(user1.getId()+"User ID is");
				return user1;
	}
	
	public static Privilege createPrivilege (Privilege privilege)throws Exception{
				JPAConnect.getEntityManager().getTransaction().begin();
				JPAConnect.getEntityManager().persist(privilege);
				JPAConnect.getEntityManager().getTransaction().commit();
				System.out.println(privilege.getId());
				return(privilege);
	}
}