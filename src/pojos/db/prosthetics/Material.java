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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "material")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Material")
public class Material implements Serializable{
	/**
	 * 
	 */

	private static final long serialVersionUID = -5860436926701456573L;
	
	@Id
	@GeneratedValue(generator = "material")
	@TableGenerator(name = "material", table = "sqlite_sequence",
		pkColumnName = "material", valueColumnName = "seq", pkColumnValue = "material")
	
	@XmlAttribute
	float priceModifier;
	@XmlAttribute
	String type;
	@XmlAttribute
	String provider;
	@XmlAttribute
	int id;
	
	
	
	@Basic(fetch = FetchType.LAZY)
	@OneToOne(fetch=FetchType.LAZY)
	@XmlTransient
	private Address address;	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@XmlTransient
	private List<Prosthetics> prosthetics;
	
	public Material() {
		super();
		this.prosthetics = new ArrayList<Prosthetics>();
	}
	
	Material(Float prc, int id, String tp, String prv, List<Prosthetics> prosthetics){
		this.priceModifier=prc;
		this.type=tp;
		this.provider=prv;
		this.id=id;
		this.prosthetics = new ArrayList<Prosthetics>();
	}
	public Material(float prc, String prv, String mat){
		this.priceModifier=prc;
		this.provider=prv;
		this.type=mat;
	}
	public Material(int id, float prc, String prv, String mat){
		this.priceModifier=prc;
		this.provider=prv;
		this.type=mat;
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "Client [id=" +id+ "price=" + priceModifier + ", type=" + type + ", provider=" + provider +
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
	public void setPriceModifier(float price){
		this.priceModifier=price;
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
	public float getPriceModifier() {
		return(this.priceModifier);
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
