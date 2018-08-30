package com.jonathanperez.perspective.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanperez.perspective.dto.UserDTO;
import com.jonathanperez.perspective.entities.User;
import com.jonathanperez.perspective.service.SecurityService;
import com.jonathanperez.perspective.service.UserService;

@RestController
@RequestMapping("/api")
public class SecurityRestController {
	
	@Autowired
	private SecurityService securityService;
	
	@PostMapping("/securities")
	public User authenticateUser(@Valid @RequestBody UserDTO userDTO) {
		User user = securityService.authenticateUser(userDTO.username, userDTO.password);
		return user;
	}
}
