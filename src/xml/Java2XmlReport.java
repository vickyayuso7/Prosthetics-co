package xml;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.*;

import org.eclipse.persistence.jaxb.JAXBContext;

import pojos.db.prosthetics.Features;
import pojos.db.prosthetics.Material;

public class Java2XmlReport {
	
	private static EntityManager em;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static void printAddress() {
		
		
		
	}
	
	private static void printClient() {
		
		
	}
	
	private static void printFeatures() {
		
		Query q1 = em.createNativeQuery("SELECT * FROM features", Features.class);
		List<Features> f = (List<Features>)q1.getResultList();
		
	}
	
	private static void printMaterial() {
		
		Query q2 = em.createNativeQuery("SELECT * FROM material", Material.class);
		List<Material> m = (List<Material>)q2.getResultList();
		
	}
	
	private static void printPayment() {
		
		
	}
	
	private static void printProsthetic() {
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		em = Persistence.createEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys = ON").executeUpdate();
		em.getTransaction().commit();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Prosthetics.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		printProsthetic();
		System.out.println("Select the feature that you want to turn into an XML file.");
		int prosthetic_id = Integer.parseInt(reader.readLine());
		Query q = em.createNativeQuery("SELECT * FROM features WHERE id = ?", Features.class);
		q.setParameter(1, prosthetic_id);
		Features prosthetic = (Prosthetics)q.getSingleResult();
		
		File file = new File("");
		marshaller.marshall(feature, file);
		marshaller.marshall(feature, System.out);
		
	
	}
	
}
