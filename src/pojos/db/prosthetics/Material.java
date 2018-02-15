package pojos.db.prosthetics;

import java.io.Serializable;

public class Material implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5860436926701456573L;
	float price;
	String type;
	String provider;
	int id;
	
	Material(int id, float prc, String tp, String prv){
		this.price=prc;
		this.type=tp;
		this.provider=prv;
		this.id=id;
	}
	Material(){
		this.price=0;
		this.provider="";
		this.type="";
		this.id=0;
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
}