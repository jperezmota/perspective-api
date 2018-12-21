package com.jonathanperez.perspective.dto;

import javax.validation.constraints.NotBlank;

public class AuthorDTO {
	@NotBlank
	public String name;
}
