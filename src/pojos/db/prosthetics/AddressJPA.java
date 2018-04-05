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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "address")
public class AddressJPA implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6759567129389835698L;
	@Id
	@GeneratedValue(generator = "address")
	@TableGenerator(name = "address", table = "sqlite_sequence",
		pkColumnName = "address", valueColumnName = "seq", pkColumnValue = "address")
	private Integer id;
	private String country;
	private Integer postCode;
	private String street;
	private String town;
	private Integer number;
	
	private String city;
	@Basic(fetch = FetchType.LAZY) //this are not retrieved until are used
	

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id")
	private Client client;	

	// This constructor is mandatory
	public AddressJPA() {
		super();
		this.client = client;
	}

	// You can create as many extra constructors as you wish
public AddressJPA(int id, String country, int postCode, String street, String town, int number, Client client, String city) {
		
		this.id = id;
		this.country = country;
		this.postCode = postCode;
		this.street = street;
		this.town = town;
		this.number = number;
		this.client=client;
		this.city=city;
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

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
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
	AddressJPA other = (AddressJPA) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

@Override
public String toString() {
	return "AddressJPA [id=" + id + ", country=" + country + ", postCode=" + postCode + ", street=" + street + ", town="
			+ town + ", number=" + number + ", city=" + city + ", client=" + client + "]";
}



}