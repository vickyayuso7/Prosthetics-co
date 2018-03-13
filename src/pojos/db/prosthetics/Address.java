package pojos.db.prosthetics;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = 6147789758100340047L;
	
	private Integer id;
	private String country;
	private Integer postCode;
	private String street;
	private String town;
	private Integer number;
	private Client client;
	private String city;
	
	public Address() {
		
		super();
		
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
	
public Address( String country, int postCode, String street, String town, int number, String city) {
		
	
		this.country = country;
		this.postCode = postCode;
		this.street = street;
		this.town = town;
		this.number = number;
		this.city=city;
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
				+ ", town=" + town + ", number=" + number + "]";
	}

	
	

	
	
	
	
	
}