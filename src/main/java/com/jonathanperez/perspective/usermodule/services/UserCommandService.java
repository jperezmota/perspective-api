package com.jonathanperez.perspective.usermodule.services;

import com.jonathanperez.perspective.usermodule.dtos.UserCreationDTO;
import com.jonathanperez.perspective.usermodule.entities.User;

public interface UserCommandService {
	public User createUser(UserCreationDTO userCreationDTO);
}
