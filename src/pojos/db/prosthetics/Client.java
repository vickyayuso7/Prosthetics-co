package pojos.db.prosthetics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;





public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4798145916410889568L;
	private Integer id;
	private Integer age;
	private String name;
	private String gender;
	private Float measures;
	private List<Prosthetics> prosthetics;
	private Address address;

	
	
	//mandatory constructor

	public Client() {
		super();
		this.prosthetics = new ArrayList<Prosthetics>();
	}
	
	// You can create as many extra constructors as you wish
		
		
		public Client (Integer age, String name, String gender, Float measures, List<Prosthetics> prosthetics, Address address) {
			super();
			this.age = age;
			this.name = name;
			this.gender = gender;
			this.measures = measures;
			this.prosthetics = new ArrayList<Prosthetics>();
			this.address= address;
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
			return "Client [id=" + id + ", age=" + age + ", name=" + name +
					", gender=" + gender + ", measures=" + measures + "address"+address+"]";
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
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

		public Float getMeasures() {
			return measures;
		}

		public void setMeasures(Float measures) {
			this.measures = measures;
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