package com.jrquiz.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
@NamedQueries({ @NamedQuery(name = User.FIND_BY_EMAIL, query = "select a from User a where (a.email = :email and a.enabled = true)"), @NamedQuery(name = User.FIND_BY_EMAILTOKEN, query = "select a from User a where a.emailtoken = :emailtoken") })
public class User implements java.io.Serializable {
	public static final String FIND_BY_EMAIL = "User.findByEmail";
	public static final String FIND_BY_EMAILTOKEN = "User.findByEmailToken";
	private static final long serialVersionUID = -1136208004146721604L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(unique = true)
	private String email;

	@JsonIgnore
	private String password;

	private String role = "";

	@Column(name = "username")
	@Size(min = 4, message = "Имя должно быть более 3-х символов")
	private String username;

	private boolean enabled;

	private String firstname;

	private String lastname;

	@Column(name = "createdDate", nullable = true)
	private Timestamp createdDate;

	private Timestamp updatetime;

	private String emailtoken;

	private Date birthday;

	private String aboutme;

	private String socialnetworktoken;

	// @Column(name = "userName")
	// private String userName;

	// @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
	// private List<Question> questions;
	//
	// @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	// private List<Comment> comments;

	// public String getUserName() {
	// return userName;
	// }
	//
	// public void setUserName(String userName) {
	// this.userName = userName;
	// }

	// public List<Question> getQuestions() {
	// return questions;
	// }
	//
	// public void setQuestions(List<Question> questions) {
	// this.questions = questions;
	// }
	//
	// public List<Comment> getComments() {
	// return comments;
	// }
	//
	// public void setComments(List<Comment> comments) {
	// this.comments = comments;
	// }

	protected User() {
	}

	public User(String email, String password, String role, boolean enabled) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
		this.createdDate = new Timestamp(new Date().getTime());
		this.updatetime = new Timestamp(new Date().getTime());
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getEmailtoken() {
		return emailtoken;
	}

	public void setEmailtoken(String emailtoken) {
		this.emailtoken = emailtoken;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	public String getSocialnetworktoken() {
		return socialnetworktoken;
	}

	public void setSocialnetworktoken(String socialnetworktoken) {
		this.socialnetworktoken = socialnetworktoken;
	}
}
