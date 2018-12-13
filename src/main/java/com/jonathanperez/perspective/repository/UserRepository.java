package com.jonathanperez.perspective.repository;

import com.jonathanperez.perspective.entities.User;

public interface UserRepository {
	
	public User findUserByUsername(String username);
	public User findUserByToken(String token);
	public void saveUser(User user);
	public void updateUser(User user);
	public User findUserByEmail(String email);

}
