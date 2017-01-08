package practise.springBoot.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	private Date birthDate;

	
	@Column(name="email")
	private String email;

	@Column(name="enabled")
	private Boolean enabled;

	@Column(name="full_name")
	private String fullName;

	@Column(name="password")
	private String password;

	@Column(name="preferred_working_hour_per_day")
	private Time preferredWorkingHourPerDay;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="user")
	private List<Note> notes;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role")
	private Role role;

	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Time getPreferredWorkingHourPerDay() {
		return this.preferredWorkingHourPerDay;
	}

	public void setPreferredWorkingHourPerDay(Time preferredWorkingHourPerDay) {
		this.preferredWorkingHourPerDay = preferredWorkingHourPerDay;
	}

	public List<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note addNote(Note note) {
		getNotes().add(note);
		note.setUser(this);

		return note;
	}

	public Note removeNote(Note note) {
		getNotes().remove(note);
		note.setUser(null);

		return note;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role roleBean) {
		this.role = roleBean;
	}

}