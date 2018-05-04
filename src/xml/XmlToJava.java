package xml;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import pojos.db.prosthetics.Client;
import pojos.db.prosthetics.Prosthetics;



public class XmlToJava {
	
	
	private static final String PERSISTENCE_PROVIDER1 = "company-provider";
	private static EntityManagerFactory factory;

	private static final String PERSISTENCE_PROVIDER = null;

	public static void main(String[] args) throws JAXBException {

		// Create the JAXBContext
		JAXBContext jaxbContext = JAXBContext.newInstance(Client.class);
		// Get the unmarshaller
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		// Use the Unmarshaller to unmarshal the XML document from a file
		File file = new File("./xmls/External-Report.xml");
		Client client = (Client) unmarshaller.unmarshal(file);

		// Print the report
		System.out.println("Client:");
		System.out.println("name: " + client.getName());
		System.out.println("gender: " + client.getGender());
		System.out.println("DateOfBirth: " + client.getDateOfBirth());
		System.out.println("Address: " + client.getAddress());
		
		List<Prosthetics> prosthetics = client.getProsthetics();
		for (Prosthetics prosthetic : prosthetics) {
			System.out.println("Prosthetic: " + prosthetic.getId());
		}

		// Store the report in the database
		// Create entity manager
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_PROVIDER1);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();

		// Create a transaction
		EntityTransaction tx1 = em.getTransaction();

		// Start transaction
		tx1.begin();

		// Persist
		// We assume the authors are not already in the database
		// In a real world, we should check if they already exist
		// and update them instead of inserting as new
		for (Prosthetics : prosthetics) {
			em.persist(prosthetics);
		}
		em.persist(client);
		
		// End transaction
		tx1.commit();
	}

}
