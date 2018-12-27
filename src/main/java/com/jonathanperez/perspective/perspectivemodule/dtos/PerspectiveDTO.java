package com.jonathanperez.perspective.perspectivemodule.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PerspectiveDTO {
	
	@NotBlank
	public String title;
	@NotBlank
	public String perspective;
	public long authorId;
	public long categoryId;
	public String thoughts;
	
	@Override
	public String toString() {
		return "PerspectiveDTO [title=" + title + ", perspective=" + perspective + ", authorId=" + authorId
				+ ", categoryId=" + categoryId + ", thoughts=" + thoughts + "]";
	}
	
}
