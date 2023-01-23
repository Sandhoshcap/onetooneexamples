package com.cg.onetoonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author")//table name in the db
public class Author {
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
	@Column(name = "author_id")
	private int authotid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int authotid, String name, String email) {
		super();
		this.authotid = authotid;
		this.name = name;
		this.email = email;
	}

	public int getAuthotid() {
		return authotid;
	}

	public void setAuthotid(int authotid) {
		this.authotid = authotid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
