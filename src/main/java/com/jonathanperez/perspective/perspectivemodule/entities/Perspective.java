package com.jonathanperez.perspective.perspectivemodule.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jonathanperez.perspective.authormodule.entities.Author;
import com.jonathanperez.perspective.categorymodule.entities.Category;
import com.jonathanperez.perspective.entities.Auditable;

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
	
	@Column(name = "title")
	@NotBlank
	@Size(min = 1, max = 40)
	private String title;
	
	@Column(name = "perspective")
	@NotBlank
	@Size(min = 1, max = 1000)
	private String perspective;
	
	@OneToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category cagetory) {
		this.category = cagetory;
	}
}
