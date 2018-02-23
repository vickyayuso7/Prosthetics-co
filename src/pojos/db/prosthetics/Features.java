package pojos.db.prosthetics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Features implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3282893934193593462L;
	private int id;
	private Float extra_price;
	private String style;
	boolean sensibility;
	boolean enhanced_movement;
	private List<Features> features;	
	
	Features(int id, String style, boolean sensibility, boolean enhanced_movement){
		this.id=id;
		this.extra_price=extra_price;
		this.sensibility=sensibility;
		this.enhanced_movement=enhanced_movement;
		this.style=style;
		this.features= new ArrayList<Features>();
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
		return "Features [id=" +id+ "sensibility="+sensibility+"enhanced_movement="+enhanced_movement+"style="+style;
	}
	
	

	public String getStyle() {
		return style;
	}


	public void setStyle(String style) {
		this.style = style;
	}

	public Float getExtra_price() {
		return extra_price;
	}


	public void setExtra_price(Float extra_price) {
		this.extra_price = extra_price;
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
	public boolean getEnhanced_movement() {
		return enhanced_movement;
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
		this.enhanced_movement=movm;
	}
	public int getId() {
		return(this.id);
	}
}