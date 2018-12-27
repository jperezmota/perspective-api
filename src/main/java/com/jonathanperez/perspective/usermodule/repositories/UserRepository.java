package com.jonathanperez.perspective.usermodule.repositories;

import com.jonathanperez.perspective.usermodule.entities.User;

public interface UserRepository {
	
	public User findUserByUsername(String username);
	public User findUserByToken(String token);
	public void saveUser(User user);
	public void updateUser(User user);
	public User findUserByEmail(String email);

}
