package pojos.db.prosthetics;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Payment implements Serializable {

	private static final long serialVersionUID = -6057556579044540426L;
	private Date deadline;
	private Integer iban;
	private String method;
	private Integer id;
	
	private List<Prosthetics> prosthetics;
	
	
	// This constructor is mandatory
	public Payment() {
		super();
		this.prosthetics = new ArrayList<Prosthetics>();
	}
	
	public Payment (Date deadline, Integer iban, String method, Integer id) {
		
		this.deadline = deadline;
		this.iban = iban;
		this.method = method;
		this.id = id;
		this.prosthetics = new ArrayList<Prosthetics>();
		
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Integer getIban() {
		return iban;
	}

	public void setIban(Integer iban) {
		this.iban = iban;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Prosthetics> getProsthetics() {
		return prosthetics;
	}

	public void setProsthetics(List<Prosthetics> prosthetics) {
		this.prosthetics = prosthetics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((deadline == null) ? 0 : deadline.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
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
		Payment other = (Payment) obj;
		if (deadline == null) {
			if (other.deadline != null)
				return false;
		} else if (!deadline.equals(other.deadline))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Payment [deadline=" + deadline + ", iban=" + iban + ", method=" + method + ", id=" + id
				+  "]";
	}

	public void addProsthetic(Prosthetics prosthetic){
		if(!prosthetics.contains(prosthetic)){
			this.prosthetics.add(prosthetic);
		}
	}
	
		public void removeProsthetic(Prosthetics prosthetic){
		if(prosthetics.contains(prosthetic)){
			this.prosthetics.remove(prosthetic);
		}
	}
		
}