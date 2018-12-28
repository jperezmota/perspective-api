package com.jonathanperez.perspective.securitymodule.services;

import com.jonathanperez.perspective.usermodule.entities.User;

public interface SecurityQueryService {
	public User authenticateUser(String username, String password);
}
