package com.hemanth.graphql.testgraphql.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book", catalog="test")
public class Books implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="isn")
	private String isn;
	
	@Column(name="title")
	private String title;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="authors")
	private String[] authors;
	
	@Column(name="publishedDate")
	private String publishedDate;
	
	public Books() {
	}
	
	public Books(String isn, String title, String publisher, String[] authors, String publishedDate) {
		super();
		this.isn = isn;
		this.title = title;
		this.publisher  = publisher;
		this.authors = authors;
		this.publishedDate = publishedDate;
	}

	public String getIsn() {
		return isn;
	}

	public void setIsn(String isn) {
		this.isn = isn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
}
