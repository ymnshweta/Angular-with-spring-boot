package com.jbkAcademy.Angular.with.spring.boot;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class User {

	@Id
	String username;

	 String password;
	 long mo;

	  String emaild;
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



	public long getMo() {
		return mo;
	}



	public void setMo(long mo) {
		this.mo = mo;
	}



	public String getEmaild() {
		return emaild;
	}



	public void setEmaild(String emaild) {
		this.emaild = emaild;
	}



	@Override
	public String toString() {
		return "Team [username=" + username + ", password=" + password + ", mo=" + mo + ", emaild=" + emaild + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(emaild, mo, password, username);
	}
	
	@Override
	public boolean equals(Object secondObject) {
		System.out.println("equal method from user");
		User user=(User)secondObject;
		if(this.username.equals(user.username) && this.password.equals(user.password)) 
			return true;
		else 
			return false;
		
		}
	  

	
}
