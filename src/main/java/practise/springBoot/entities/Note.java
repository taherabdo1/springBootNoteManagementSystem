package practise.springBoot.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the note database table.
 * 
 */
@Entity
@NamedQuery(name="Note.findAll", query="SELECT n FROM Note n")
public class Note extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="description")
	private String description;

	@Column(name="period")
	private double period;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user")
	private User user;

	public Note() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String desccription) {
		this.description = desccription;
	}

	public double getPeriod() {
		return this.period;
	}

	public void setPeriod(double period) {
		this.period = period;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User userBean) {
		this.user = userBean;
	}

}