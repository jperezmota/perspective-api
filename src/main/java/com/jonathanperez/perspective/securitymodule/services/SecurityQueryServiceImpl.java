package com.jonathanperez.perspective.securitymodule.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.sharedmodule.exceptions.ResourceNotFoundException;
import com.jonathanperez.perspective.usermodule.entities.User;
import com.jonathanperez.perspective.usermodule.services.UserQueryService;

@Service
@Transactional
public class SecurityQueryServiceImpl implements SecurityQueryService {

	@Autowired
	private UserQueryService userQueryService;
	
	@Override
	public User authenticateUser(String username, String password) {
		
		User user = userQueryService.findUserByUsername(username);
		boolean userNotFound = user == null;
		if(userNotFound) {
			throw new ResourceNotFoundException("User", "those credential", "");
		}
		if(!user.isEnabled()) {
			throw new ResourceNotFoundException("User", "those credential", "");
		}
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		boolean passwordMatch = bCryptPasswordEncoder.matches(password, user.getPassword());
		if(!passwordMatch) {
			throw new ResourceNotFoundException("User", "those credential", "");
		}
		
		return user;
	
	}

}
