package pojos.db.prosthetics;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Payment implements Serializable {

	private static final long serialVersionUID = -6057556579044540426L;
	private Date deadline;
	private Integer isbn;
	private String method;
	private Integer id;
	
	private List<Prosthetics> prosthetics;
	
	
	// This constructor is mandatory
	public Payment() {
		super();
		this.prosthetics = new ArrayList<Prosthetics>();
	}
	
	public Payment (Date deadline, Integer isbn, String method, Integer id) {
		
		this.deadline = deadline;
		this.isbn = isbn;
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

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
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
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		return true;
	}
	
	public void addProsthetic(Prosthetic prosthetic ){
	@Override
	public String toString() {
		return "Payment [deadline=" + deadline + ", isbn=" + isbn + ", method=" + method + ", id=" + id
				+  "]";
	}

	public void addProsthetic(Prosthetics prosthetic){
	@Override
	public String toString() {
		return "Payment [deadline=" + deadline + ", isbn=" + isbn + ", method=" + method + ", id=" + id
				+  "]";
	}

	public void addProsthetic(Prosthetics prosthetic){
	@Override
	public String toString() {
		return "Payment [deadline=" + deadline + ", isbn=" + isbn + ", method=" + method + ", id=" + id
				+  "]";
	}

	public void addProsthetic(Prosthetics prosthetic){
	@Override
	public String toString() {
		return "Payment [deadline=" + deadline + ", isbn=" + isbn + ", method=" + method + ", id=" + id
				+  "]";
	}

	public void addProsthetic(Prosthetics prosthetic){
		if(!prosthetics.contains(prosthetic)){
			this.prosthetics.add(prosthetic);
		}
		public void removeProsthetic(Prosthetics prosthetic){
		if(prosthetics.contains(prosthetic)){
			this.prosthetics.remove(prosthetic);
		}
	}
	}