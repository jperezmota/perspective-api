package com.jonathanperez.perspective.securitymodule.services;

import com.jonathanperez.perspective.usermodule.dtos.UserCreationDTO;
import com.jonathanperez.perspective.usermodule.entities.User;

public interface SecurityService {
	public User authenticateUser(String username, String password);
	public User createUser(UserCreationDTO userCreationDTO);
}
