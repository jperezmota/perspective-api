package com.jonathanperez.perspective.dto;

import javax.validation.constraints.NotNull;

public class PerspectiveDTO {
	@NotNull
	public String perspective;
	public long authorId;
	public long categoryId;
	public String thoughts;
	
	@Override
	public String toString() {
		return "PerspectiveDTO [perspective=" + perspective + ", authorId=" + authorId + ", categoryId=" + categoryId
				+ ", thoughts=" + thoughts + "]";
	}
	
}
