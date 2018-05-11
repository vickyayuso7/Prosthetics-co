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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import utils.SQLDateAdapter;




@Entity
@Table(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4798145916410889568L;
	
	 
	@Id
	@GeneratedValue(generator = "client")
	@TableGenerator(name = "client", table = "sqlite_sequence",
		pkColumnName = "client", valueColumnName = "seq", pkColumnValue = "client")
		
	@XmlAttribute	
	private Integer id;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String gender;
	@XmlAttribute
	@XmlJavaTypeAdapter(SQLDateAdapter.class) //Bajar del proyecto de rodrigo
	private Date dateOfBirth;
	
	private int userId;
	@Basic(fetch = FetchType.LAZY)
	@OneToOne(fetch=FetchType.LAZY)
	@XmlAttribute
	private Address address;	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@XmlElement (name = "Prosthetic")
	@XmlElementWrapper(name="Prosthetics")
	private List<Prosthetics> prosthetics;
	
	
	//mandatory constructor
	public Client() {
		super();
		this.prosthetics = new ArrayList<Prosthetics>();
	}
	
	

	
	// You can create as many extra constructors as you wish
		
		
		public Client (Date dateOfBirth, String name, String gender, List<Prosthetics> prosthetics, Address address) {
			super();
			this.dateOfBirth = dateOfBirth;
			this.name = name;
			this.gender = gender;
			this.prosthetics = new ArrayList<Prosthetics>();
			this.address= address;
		}

		public Client(int idp, Date dateOfBirth, String name, String gender) {
			super();
			this.id=idp;
			this.dateOfBirth = dateOfBirth;
			this.name = name;
			this.gender = gender;
			
			this.prosthetics = new ArrayList<Prosthetics>();
			
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
			Client other = (Client) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "Client [id=" + id + ", date of birth=" + dateOfBirth + ", name=" + name +
					", gender=" + gender  + "address"+address+"]";
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}


		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public List<Prosthetics> getProsthetics() {
			return prosthetics;
		}

		public void setProsthetics(List<Prosthetics> prosthetics) {
			this.prosthetics = prosthetics;
		}
		public int getUserId() {
			return this.userId;
		}
		public void setUserId(int id) {
			this.userId=id;
		}
		
		public void addProsthetics(Prosthetics prosthetic) {
			if (!prosthetics.contains(prosthetic)) {
				this.prosthetics.add(prosthetic);
			}
		}

		// Additional method to remove from a list
		public void removeProsthetics(Prosthetics prosthetic) {
			if (prosthetics.contains(prosthetic)) {
				this.prosthetics.remove(prosthetic);
			}
		}

}

