package com.jonathanperez.perspective.securitymodule.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanperez.perspective.dto.UserCreationDTO;
import com.jonathanperez.perspective.dto.UserDTO;
import com.jonathanperez.perspective.entities.User;
import com.jonathanperez.perspective.securitymodule.services.SecurityService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SecurityRestController {
	
	@Autowired
	private SecurityService securityService;
	
	@PostMapping("/securities")
	public User authenticateUser(@Valid @RequestBody UserDTO userDTO) {
		User user = securityService.authenticateUser(userDTO.username, userDTO.password);
		return user;
	}
	
}
