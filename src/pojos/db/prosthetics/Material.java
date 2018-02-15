
package pojos.db.prosthetics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Material implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -5860436926701456573L;
	float price;
	String type;
	String provider;
	int id;
	private List<Prosthetics> prosthetics;
	
	Material(int id, float prc, String tp, String prv, List<Prosthetics> prosthetics){
		this.price=prc;
		this.type=tp;
		this.provider=prv;
		this.id=id;
		this.prosthetics = new ArrayList<Prosthetics>();
	}
	Material(){
		this.price=0;
		this.provider="";
		this.type="";
		this.id=0;
		this.prosthetics = new ArrayList<Prosthetics>();
	}
	
	@Override
	public String toString() {
		return "Client [id=" +id+ "price=" + price + ", type=" + type + ", provider=" + provider +
				"]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Material other = (Material) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public void setPrice(float price){
		this.price=price;
	}
	public void setType(String type) {
		this.type=type;
	}
	public void setProvider(String provider) {
		this.provider=provider;
	}
	public void setId(int id) {
		this.id=id;
	}
	public float getPrice() {
		return(this.price);
	}
	public String getType() {
		return(this.type);
	}
	public String getProvider() {
		return(this.provider);
	}
	public int getId() {
		return(this.id);
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
