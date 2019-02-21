package com.rekik.riri_restfulwebservices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;



import java.util.Date;
import java.util.List;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer idInteger;

	@Size(min=2, message = "Name should at least have two characters")
	private String nameString;

	@Past
	private java.util.Date birthDate;
	
	@OneToMany(mappedBy="user")
    private List<Post> posts;

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


	public List<Post> getPosts() {
		return posts;
	}


	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	

}
