package pojos.db.prosthetics;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "prosthetics")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Prosthetics" )
public class Prosthetics implements Serializable {

	private static final long serialVersionUID = 3745716868877683707L;
	
	@Id
	@GeneratedValue(generator = "prosthetics")
	@TableGenerator(name = "prosthetics", table = "sqlite_sequence",
		pkColumnName = "prosthetics", valueColumnName = "seq", pkColumnValue = "prosthetics")
	
	//To track exiting prosthetics
	@XmlAttribute
	private Integer id;
	@XmlElement
	private Float bestPrice;
	@XmlElement
	private Float size;
	@XmlElement
	private Float weight;
	@XmlElement
	private String typeOfFunctionality;
	@XmlElement
	private String color;
	@XmlElement
	private String typeOfAmputation;
	
	@Basic(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_id")
	@XmlElement
	private Payment payment;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@XmlElement(name = "Material")
	@XmlElementWrapper(name = "Materials")
	private List<Material> materials;
	

	@ManyToMany(fetch = FetchType.LAZY)
	@XmlElement(name = "Feature")
	@XmlElementWrapper(name = "Features")
	private List<Features> features;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@XmlElement(name = "Client")
	@XmlElementWrapper(name= "Clients")
	private List<Client> clients;
	
	//Need an empty constructor
	
	public Prosthetics() {
		
		super();
		this.clients = new ArrayList<Client>();
		this.features = new ArrayList<Features>();
		this.materials = new ArrayList<Material>();
		
	}
	
	public Prosthetics(Float size,Float bestPrice, Float weight,String typeOfFunctionality,String color,String typeOfAmputation, Payment payment) {
		
		super();
		this.size = size;
		this.bestPrice= bestPrice;
		this.weight = weight;
		this.typeOfFunctionality= typeOfFunctionality;
		this.color = color;
		this.typeOfAmputation = typeOfAmputation;
		this.payment= payment;
		this.clients = new ArrayList<Client>();
		this.features = new ArrayList<Features>();
		this.materials = new ArrayList<Material>();
		
		
	}
	
	public Prosthetics (int id, float size, float weight, String typeOfFuncionality, String type_of_amputation, String color, float bestPrice) {
		
	super();
	this.id=id;
	this.size=size;
	this.weight=weight;
	this.typeOfFunctionality=typeOfFuncionality;
	this.typeOfAmputation=type_of_amputation;
	this.color=color;
	this.bestPrice=bestPrice;
	
	}

	//Public getters and setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getSize() {
		return size;
	}

	public void setSize(Float size) {
		this.size = size;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getTypeOfFunctionality() {
		return typeOfFunctionality;
	}

	public void setTypeOfFunctionality(String typeOfFunctionality) {
		this.typeOfFunctionality = typeOfFunctionality;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Float getBestPrice() {
		return bestPrice;
	}

	public void setBestPrice(Float bestPrice) {
		this.bestPrice = bestPrice;
	}

	public String getTypeOfAmputation() {
		return typeOfAmputation;
	}

	public void setTypeOfAmputation(String typeOfAmputation) {
		this.typeOfAmputation = typeOfAmputation;
	}
	

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Features> getFeatures() {
		return features;
	}

	public void setFeatures(List<Features> features) {
		this.features = features;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String toString() {
		
		return "Prosthetics [id=" + id + ", bestPrice=" +bestPrice+"size=" + size + ", weight=" + weight + ", typeOfFunctionality="
				+ typeOfFunctionality + ", color=" + color + ", typeOfAmputation=" + typeOfAmputation
				+ ", features=" + features + ", materials=" + materials + "payment=" +payment+"]";
		
	}


	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
		
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prosthetics other = (Prosthetics) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
		
	}

	public void addClient(Client client) {
		
		if (!clients.contains(client)) {
				
			this.clients.add(client);
				
		}
			
	}

	public void removeClient(Client client) {
		
		if (clients.contains(client)) {
			
			this.clients.remove(client);
			
			}
		
	}
			
	public void addFeatures(Features feature) {
		
		if (!features.contains(feature)) {
			
			this.features.add(feature);
			
		}
		
	}

	public void removeFeatures(Features feature) {
		
		if (features.contains(feature)) {
					
			this.features.remove(feature);
		
		}
		
	}
	
	public void addMaterial(Material material) {
			
		if (!materials.contains(material)) {
						
			this.materials.add(material);
			
		}
	
	}

	public void removeMaterial(Material material) {
		
		if (materials.contains(material)) {
			
			this.materials.remove(material);
		
		}

	}
	
}
