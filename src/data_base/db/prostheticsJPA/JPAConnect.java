package data_base.db.prostheticsJPA;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import data_base.db.prosthetics.*;

public class JPAConnect implements Yisus {
	private static EntityManager em;
	
	@Override
	public void establishConnection() {
		em= Persistence.createEntityManagerFactory("connectionJPA").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
		
		
	}

	@Override
	public void closeConnection() {
		em.close();
	}
	
	public static EntityManager getEntityManager() {
		return em;
	}

}
