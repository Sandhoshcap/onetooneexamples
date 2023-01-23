package com.cg.onetoonebook.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
	@Column(name = "book_id")
	private int bookid;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "published_date")
	private LocalDate publisheddate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id")
	private Author authorid;

	public Author getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Author authorid) {
		this.authorid = authorid;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookid, String title, String description, LocalDate publisheddate) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.description = description;
		this.publisheddate = publisheddate;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getPublisheddate() {
		return publisheddate;
	}

	public void setPublisheddate(LocalDate publisheddate) {
		this.publisheddate = publisheddate;
	}
}
	

