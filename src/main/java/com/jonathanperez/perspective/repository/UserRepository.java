package com.jonathanperez.perspective.repository;

import com.jonathanperez.perspective.entities.User;

public interface UserRepository {
	
	public User findUserByUsername(String username);

}
