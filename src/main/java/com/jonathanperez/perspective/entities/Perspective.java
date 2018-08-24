package com.jonathanperez.perspective.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "perspectives")
@JsonIgnoreProperties(value = {"createdBy", 
        "createdDate", 
        "lastModifiedBy", 
        "lastModifiedDate", 
        "deleted", 
        "deletedBy", 
        "deletedDate"})
public class Perspective extends Auditable<String>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "perspective")
	@NotNull
	private String perspective;
	
	@OneToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@OneToOne
	@JoinColumn(name = "category_id")
	private Category cagetory;
	
	@Column(name = "thoughts")
	private String thoughts;

	public Perspective() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPerspective() {
		return perspective;
	}

	public void setPerspective(String perspective) {
		this.perspective = perspective;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Category getCagetory() {
		return cagetory;
	}

	public void setCagetory(Category cagetory) {
		this.cagetory = cagetory;
	}
}
