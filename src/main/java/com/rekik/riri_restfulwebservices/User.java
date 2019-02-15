package com.rekik.riri_restfulwebservices;

import java.util.Date;

public class User {
	private Integer idInteger; 
	private String nameString;
	private java.util.Date birthDate;
	

	public User() {
		super();
	}
	
	
	public User(Integer idInteger, String nameString, Date birthDate) {
		super();
		this.idInteger = idInteger;
		this.nameString = nameString;
		this.birthDate = birthDate;
	}


	public Integer getIdInteger() {
		return idInteger;
	}
	public void setIdInteger(Integer idInteger) {
		this.idInteger = idInteger;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public java.util.Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(java.util.Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	

}
