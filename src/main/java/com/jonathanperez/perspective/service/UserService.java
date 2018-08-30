package com.jonathanperez.perspective.service;

import com.jonathanperez.perspective.entities.User;

public interface UserService {
	public User findUserByUsername(String username);
}
