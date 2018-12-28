package com.jonathanperez.perspective.usermodule.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.usermodule.entities.User;
import com.jonathanperez.perspective.usermodule.repositories.UserQueryRepository;

@Service
@Transactional
public class UserQueryServiceImpl implements UserQueryService {
	
	@Autowired
	private UserQueryRepository userQueryRepository;

	@Override
	public User findUserByUsername(String username) {
		return userQueryRepository.findUserByUsername(username);
	}
	
	@Override
	public boolean verifyUserEmailExistance(String email) {
		boolean userExistance;
		
		try {
			User user = userQueryRepository.findUserByEmail(email);
			userExistance = true;
		}catch (Exception ex) {
			userExistance = false;
		}
		
		return false;
	}

}
