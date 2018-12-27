package com.jonathanperez.perspective.usermodule.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanperez.perspective.usermodule.dtos.UserCreationDTO;
import com.jonathanperez.perspective.usermodule.entities.User;
import com.jonathanperez.perspective.usermodule.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody UserCreationDTO userCreationDTO) {
		return userService.createUser(userCreationDTO);
	}
}
