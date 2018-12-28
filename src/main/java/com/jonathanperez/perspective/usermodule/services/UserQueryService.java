package com.jonathanperez.perspective.usermodule.services;

import com.jonathanperez.perspective.usermodule.entities.User;

public interface UserQueryService {
	public User findUserByUsername(String username);
	public boolean verifyUserEmailExistance(String email);
}
