package com.jonathanperez.perspective.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jonathanperez.perspective.entities.Author;
import com.jonathanperez.perspective.entities.Category;

public class PerspectiveDTO {
	public long id;
	@NotNull
	public String perspective;
	public long authorId;
	public long categoryId;
	public String thoughts;
	
	@Override
	public String toString() {
		return "PerspectiveDTO [id=" + id + ", perspective=" + perspective + ", authorId=" + authorId + ", categoryId="
				+ categoryId + ", thoughts=" + thoughts + "]";
	}
	
	
}
