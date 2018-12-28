package com.jonathanperez.perspective.securitymodule.services;

import com.jonathanperez.perspective.usermodule.entities.User;

public interface SecurityCommandService {
	public User authenticateUser(String username, String password);
}
