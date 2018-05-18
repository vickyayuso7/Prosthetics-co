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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.eclipse.persistence.jpa.config.Cascade;

@Entity
@Table(name = "UserType")
public class Privilege implements Serializable {

	private static final long serialVersionUID = -3005995623235179539L;
	@Id
	@GeneratedValue(generator = "UserType")
	@TableGenerator(name = "UserType", table = "sqlite_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "UserType")
	private Integer id;
	private int privilege;
	
	@OneToMany(mappedBy="privilege", fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
	private List<User> user;


	public Privilege(int privilege) {
		super();
		user=new ArrayList <User>();
		this.privilege=privilege;
	
	}
	public Privilege() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPrivilege() {
		return privilege;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public List<User> getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user.add(user);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Privilege [id=" + id + ", option=" + privilege + "]";
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
