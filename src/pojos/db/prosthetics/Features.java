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
@Table(name = "features")

public class Features implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3282893934193593462L;
	
	@Id
	@GeneratedValue(generator = "features")
	@TableGenerator(name = "features", table = "sqlite_sequence",
		pkColumnName = "features", valueColumnName = "seq", pkColumnValue = "features")
	
	
	private int id;
	private Float extraPrice;
	private String style;
	boolean sensibility;
	boolean enhancedMovement;
	private List<Features> features;	
	
	
@Basic(fetch = FetchType.LAZY)	
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Prosthetics> prosthetics;

	public Features() {
		super();
		this.prosthetics = new ArrayList<Prosthetics>();
	}
	
	public Features(int id, Float extraPrice, String style, boolean sensibility, boolean enhancedMovement){
		this.id=id;
		this.extraPrice=extraPrice;
		this.sensibility=sensibility;
		this.enhancedMovement=enhancedMovement;
		this.style=style;
		this.features= new ArrayList<Features>();
	}
	
	public Features(float extraprice,String Style, boolean sensibility, boolean enhanced ){
		this.extraPrice=extraprice;
		this.style=Style;
		this.sensibility= sensibility;
		this.enhancedMovement=enhanced;
	}
	

	public void setEnhancedMovement(boolean enhancedMovement) {
		this.enhancedMovement = enhancedMovement;
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
		Features other = (Features) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	public String toString() {
		return "Features [id=" +id+ "sensibility="+sensibility+"enhancedMovement="+enhancedMovement+"style="+style;
	}
	
	

	public String getStyle() {
		return style;
	}


	public void setStyle(String style) {
		this.style = style;
	}

	public Float getExtraPrice() {
		return extraPrice;
	}


	public void setExtraPrice(Float extraPrice) {
		this.extraPrice = extraPrice;
	}

	public List<Features> getFeatures() {
		return features;
	}


	public void setFeatures(List<Features> features) {
		this.features = features;
	}
	
	public void addFeatures(Features feature) {
		if(!features.contains(feature)) {
			this.features.add(feature);
		}
	}
	
	public void removeFeatures(Features feature) {
		if(features.contains(feature)) {
			this.features.remove(feature);
		}
	}
	public boolean getSensibility() {
		return sensibility;
	}
	public boolean getEnhancedMovement() {
		return enhancedMovement;
	}
	public void setType(String st) {
		this.style=st;
	}
	public void setId(int id) {
		this.id=id;
	} 
	public void setSensibility(boolean sens) {
		this.sensibility=sens;
	}
	public void setEnhanced_movement(boolean movm) {
		this.enhancedMovement=movm;
	}
	public int getId() {
		return(this.id);
	}
}