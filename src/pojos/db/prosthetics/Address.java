package pojos.db.prosthetics;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;





@Entity
@Table(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Address")
public class Address implements Serializable {

	private static final long serialVersionUID = 6147789758100340047L;
	
	
	@Id
	@GeneratedValue(generator = "address")
	@TableGenerator(name = "address", table = "sqlite_sequence",
		pkColumnName = "address", valueColumnName = "seq", pkColumnValue = "address")
	
	
	@XmlAttribute
	private Integer id;
	@XmlAttribute
	private String country;
	@XmlAttribute
	private Integer postCode;
	@XmlAttribute
	private String street;
	@XmlAttribute
	private String town;
	@XmlAttribute
	private Integer number;
	@XmlAttribute
	private String city;
	
	
	@Basic(fetch = FetchType.LAZY) //this are not retrieved until are used
	

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id")
	@XmlTransient
	private Client client;	

	public Address() {
		super();
		this.client = client;
	}
	
	
	
	public Address(int id, String country, int postCode, String street, String town, int number, Client client, String city) {
		
		
		this.id = id;
		this.country = country;
		this.postCode = postCode;
		this.street = street;
		this.town = town;
		this.number = number;
		this.client=client;
		this.city=city;
	}
	

public Address( int id, String country, int postCode, String street, String town, int number) {

		
		this.id= id;
		this.country = country;
		this.postCode = postCode;
		this.street = street;
		this.town = town;
		this.number = number;
	
	}

public Address( int id, String country, String town, String city) {

	
	this.id= id;
	this.country = country;
	
	this.town = town;
	this.city = city;

}


	public String getCity() {
		return(this.city);
	}
	public void setCity(String city) {
		this.city=city;
	}
	public Client getClient() {
		return(this.client);
	}
	
	public void setClient(Client cln) {
		this.client= cln; 
	}
	
	public Integer getId() {
		
		return id;
		
	}

	public void setId(Integer id) {
		
		this.id = id;
		
	}

	public String getCountry() {
		
		return country;
		
	}

	public void setCountry(String country) {
		
		this.country = country;
		
	}

	public Integer getPostCode() {
		
		return postCode;
		
	}

	public void setPostCode(Integer postCode) {
		
		this.postCode = postCode;
		
	}

	public String getStreet() {
		
		return street;
		
	}

	public void setStreet(String street) {
		
		this.street = street;
		
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", country=" + country + ", postCode=" + postCode + ", street=" + street
				+ ", town=" + town + ", number=" + number + ", city="+city+"]";
	}

	
	

	
	
	
	
	
}