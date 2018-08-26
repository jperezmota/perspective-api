package com.jonathanperez.perspective.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class UserDTO {
	@NotBlank
	public String username;
	@NotBlank
	public String password;
	public List<String> authorities;
}
