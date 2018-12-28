package com.jonathanperez.perspective.securitymodule.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanperez.perspective.securitymodule.services.SecurityQueryService;
import com.jonathanperez.perspective.usermodule.dtos.UserDTO;
import com.jonathanperez.perspective.usermodule.entities.User;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SecurityCommandRestController {
	
	@Autowired
	private SecurityQueryService securityService;
	
	@PostMapping("/securities")
	public User authenticateUser(@Valid @RequestBody UserDTO userDTO) {
		User user = securityService.authenticateUser(userDTO.username, userDTO.password);
		return user;
	}
	
}
