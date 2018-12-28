package com.jonathanperez.perspective.usermodule.repositories;

import com.jonathanperez.perspective.usermodule.entities.User;

public interface UserCommandRepository {
	public void saveUser(User user);
	public void updateUser(User user);
}
