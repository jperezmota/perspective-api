package com.jonathanperez.perspective.service;

import com.jonathanperez.perspective.dto.UserCreationDTO;
import com.jonathanperez.perspective.entities.User;

public interface UserService {
	public User findUserByUsername(String username);
	public User createUser(UserCreationDTO userCreationDTO);
	public boolean verifyUserEmailExistance(String email);
}
