package pojos.db.prosthetics;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Users")
public class User implements Serializable {

	private static final long serialVersionUID = -3005995623235179539L;
	@Id
	@GeneratedValue(generator = "Users")
	@TableGenerator(name = "Users", table = "sqlite_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "Users")

	//
	private Integer id;
	private String name;
	private String password;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name = "userType_id")
	private Privilege privilege;

	public User(Integer id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public User (String name, String password) {
		super();
		
		this.name = name;
		this.password = password;
		
	}
public User() {
	super();
	this.id=id;
	this.name=name;
	this.password=password;
}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setUserType(Privilege userType) {
		this.privilege = userType;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", privilege=" + privilege + "]";
	}
	
	
	

}
