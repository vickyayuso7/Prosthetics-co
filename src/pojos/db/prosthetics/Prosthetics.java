package pojos.db.prosthetics;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Prosthetics implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 3745716868877683707L;
	private Integer id;
	private Float size;
	private Float weight;
	private String type_of_functionality;
	private String color;
	private String type_of_amputation;
	
	private List<Client> clients;
	private List<Features> features;
	private List<Material> materials;
	
	public Prosthetics() {
		super();
		this.clients = new ArrayList<Client>();
		this.features = new ArrayList<Features>();
		this.materials = new ArrayList<Material>();
	}
	
	public Prosthetics(Float size,Float weight,String type_of_functionality,String color,String type_of_amputation) {
		super();
		this.size = size;
		this.weight = weight;
		this.type_of_functionality= type_of_functionality;
		this.color = color;
		this.type_of_amputation = type_of_amputation;
		this.clients = new ArrayList<Client>();
		this.features = new ArrayList<Features>();
		this.materials = new ArrayList<Material>();

	}

	@Override
	public String toString() {
		return "Prosthetics [id=" + id + ", size=" + size + ", weight=" + weight + ", type_of_functionality="
				+ type_of_functionality + ", color=" + color + ", type_of_amputation=" + type_of_amputation
				+ ", features=" + features + ", materials=" + materials + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((materials == null) ? 0 : materials.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((type_of_amputation == null) ? 0 : type_of_amputation.hashCode());
		result = prime * result + ((type_of_functionality == null) ? 0 : type_of_functionality.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (materials == null) {
			if (other.materials != null)
				return false;
		} else if (!materials.equals(other.materials))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (type_of_amputation == null) {
			if (other.type_of_amputation != null)
				return false;
		} else if (!type_of_amputation.equals(other.type_of_amputation))
			return false;
		if (type_of_functionality == null) {
			if (other.type_of_functionality != null)
				return false;
		} else if (!type_of_functionality.equals(other.type_of_functionality))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

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

	public String getType_of_functionality() {
		return type_of_functionality;
	}

	public void setType_of_functionality(String type_of_functionality) {
		this.type_of_functionality = type_of_functionality;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType_of_amputation() {
		return type_of_amputation;
	}

	public void setType_of_amputation(String type_of_amputation) {
		this.type_of_amputation = type_of_amputation;
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
	
		public void addClient(Client client) {
			if (!clients.contains(client)) {
				this.clients.add(client);
			}
		}

		public void removeClient(Client client) {
			if (clients.contains(client)) {
				this.clients.remove(client);
			}}
			public void addFeatures(Features feature) {
				if (!features.contains(feature)) {
					this.features.add(feature);
				}
			}

			public void removeFeatures(Features feature) {
				if (features.contains(feature)) {
					this.features.remove(feature);
				}}
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
