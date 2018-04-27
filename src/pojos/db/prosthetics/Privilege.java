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
@Table(name = "userType")
public class Privilege implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3005995623235179539L;
	@Id
	@GeneratedValue(generator = "Privilege")
	@TableGenerator(name = "Privilege", table = "sqlite_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "Privilege")

	private Integer id;
	private boolean option;
	
	@Basic(fetch = FetchType.LAZY)

	@ManyToMany(fetch = FetchType.LAZY)
	private List<User> user;

	@OneToOne (fetch=FetchType.LAZY)
	private Privilege privilege;

	public Privilege(Integer id, boolean privilege) {
		super();
		this.id = id;
		this.option=privilege;
	
	}
	public Privilege() {
		super();
		this.id=id;
		this.option=option;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean getPrivilege() {
		return option;
	}

	public void setPrivilege(boolean privilege) {
		this.option = privilege;
	}

	public List<User> getUser() {
		return user;
	}
	public Privilege getPRivilege() {
		return privilege;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Privilege [id=" + id + ", option=" + option + ", user=" + user + ", privilege=" + privilege + "]";
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
		Privilege other = (Privilege) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
