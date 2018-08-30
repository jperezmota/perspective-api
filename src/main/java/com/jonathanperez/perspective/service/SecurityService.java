package com.jonathanperez.perspective.service;

import com.jonathanperez.perspective.entities.User;

public interface SecurityService {
	public User authenticateUser(String username, String password);
}
