package com.jonathanperez.perspective.usermodule.services;

import com.jonathanperez.perspective.usermodule.dtos.UserCreationDTO;
import com.jonathanperez.perspective.usermodule.entities.User;

public interface UserService {
	public User findUserByUsername(String username);
	public User createUser(UserCreationDTO userCreationDTO);
	public boolean verifyUserEmailExistance(String email);
}
