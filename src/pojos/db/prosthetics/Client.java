package pojos.db.prosthetics;
import java.io.Serializable;
<<<<<<< HEAD
import java.time.*;
import java.util.*;

=======
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
>>>>>>> branch 'master' of https://github.com/vickyayuso7/Prosthetics-co.git





public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4798145916410889568L;
	private Integer id;
	private String name;
	private String gender;
	private List<Prosthetics> prosthetics;
	private Address address;
	private LocalDate date_of_birth;
	
	
	//mandatory constructor

	public Client() {
		super();
		this.prosthetics = new ArrayList<Prosthetics>();
	}
	
	// You can create as many extra constructors as you wish
		
		
		public Client (LocalDate date_of_birth, String name, String gender, List<Prosthetics> prosthetics, Address address) {
			super();
			this.date_of_birth = date_of_birth;
			this.name = name;
			this.gender = gender;
			this.prosthetics = new ArrayList<Prosthetics>();
			this.address= address;
		}

		public Client(int id, LocalDate date_of_birth, String name, String gender) {
			super();
			this.id=id;
			this.date_of_birth = date_of_birth;
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
			return "Client [id=" + id + ", date of birth=" + date_of_birth + ", name=" + name +
					", gender=" + gender  + "address"+address+"]";
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public LocalDate getDate_of_birth() {
			return date_of_birth;
		}

		public void setDate_of_Birth(LocalDate date_of_birth) {
			this.date_of_birth = date_of_birth;
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
