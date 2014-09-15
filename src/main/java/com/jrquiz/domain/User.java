package com.jrquiz.domain;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity(name = "Users")
public class User {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "username")
	@Size(min = 4, message = "Имя должно быть более 3-х символов")
	private String username;

	private String password;

	private boolean enabled;

	private String email;

	private String firstname;

	private String lastname;

	@Column(name = "createdDate", nullable = true)
	private Timestamp createdDate;

	private Timestamp updatetime;

	private String emailtoken;

	private Date birthday;

	private String aboutme;

	private String socialnetworktoken;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
