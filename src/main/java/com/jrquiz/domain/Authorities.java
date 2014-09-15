package com.jrquiz.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Authorities")
public class Authorities {

	@Id
	private String username;

	private int userID;

	private String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}
