package com.jonathanperez.perspective.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserCreationDTO {
	@NotBlank
	public String username;
	@NotBlank
	public String password;
	@NotBlank
	public String passwordConfirmation;
	@NotBlank
	@Email
	public String email;
	
	@Override
	public String toString() {
		return "UserCreationDTO [username=" + username + ", password=" + password + ", passwordConfirmation="
				+ passwordConfirmation + ", email=" + email + "]";
	}

}
