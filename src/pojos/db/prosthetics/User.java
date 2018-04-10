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
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3005995623235179539L;
	@Id
	@GeneratedValue(generator = "user")
	@TableGenerator(name = "user", table = "sqlite_sequence", pkColumnName = "user", valueColumnName = "seq", pkColumnValue = "user")

	
	private Integer id;
	private String name;
	private String password;
	
	@Basic(fetch = FetchType.LAZY)
	@OneToOne (fetch=FetchType.LAZY)
	private User user;
	

}
