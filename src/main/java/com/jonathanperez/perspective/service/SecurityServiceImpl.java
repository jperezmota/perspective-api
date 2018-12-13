package com.jonathanperez.perspective.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.dto.UserCreationDTO;
import com.jonathanperez.perspective.entities.User;
import com.jonathanperez.perspective.exception.ResourceNotFoundException;

@Service
@Transactional
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private UserService userService;
	
	@Override
	public User authenticateUser(String username, String password) {
		
		User user = userService.findUserByUsername(username);
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

	@Override
	public User createUser(UserCreationDTO userCreationDTO) {
		return null;
	}

}
