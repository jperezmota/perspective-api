package com.jonathanperez.perspective.usermodule.repositories;

import com.jonathanperez.perspective.usermodule.entities.User;

public interface UserQueryRepository {
	
	public User findUserByUsername(String username);
	public User findUserByToken(String token);
	public User findUserByEmail(String email);

}
