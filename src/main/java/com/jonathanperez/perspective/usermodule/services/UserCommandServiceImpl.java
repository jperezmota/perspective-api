package com.jonathanperez.perspective.usermodule.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.securitymodule.entities.Authority;
import com.jonathanperez.perspective.securitymodule.shared.Authorities;
import com.jonathanperez.perspective.usermodule.dtos.UserCreationDTO;
import com.jonathanperez.perspective.usermodule.entities.User;
import com.jonathanperez.perspective.usermodule.repositories.UserCommandRepository;

@Service
@Transactional
public class UserCommandServiceImpl implements UserCommandService {
	
	@Autowired
	private UserCommandRepository userCommandRepository;
	@Autowired
	private UserQueryService userQueryService;

	@Override
	public User createUser(UserCreationDTO userCreationDTO) {
		validateUserData(userCreationDTO);
		User user = createUserEntity(userCreationDTO);
		saveUser(user);
		
		return user;
	}
	
	private void validateUserData(UserCreationDTO userCreationDTO) {
		String validationMessage = "";
		
		boolean userAlreadyExists = userQueryService.findUserByUsername(userCreationDTO.username) != null;
		if(userAlreadyExists) {
			validationMessage += "Username already in use.";
		}
		
		boolean emailAlreadyExists = userQueryService.verifyUserEmailExistance(userCreationDTO.email);
		if(emailAlreadyExists) {
			validationMessage += "Email already in use.";
		}
		
		boolean passwordsDoNotMatch = !userCreationDTO.password.equals(userCreationDTO.passwordConfirmation);
		if(passwordsDoNotMatch) {
			validationMessage += "Password do not match with your password confirmation.";
		}
		
		boolean validationHasErrors = validationMessage.length() > 1;
		if(validationHasErrors) {
			throw new RuntimeException(validationMessage);
		}
	}
	
	private User createUserEntity(UserCreationDTO userCreationDTO) {
		String encryptedPassword = new BCryptPasswordEncoder().encode(userCreationDTO.password);
		String token = new BCryptPasswordEncoder().encode(userCreationDTO.username + new Date());
		
		User user = new User();
		user.setUsername(userCreationDTO.username);
		user.setPassword(encryptedPassword);
		user.setEmail(userCreationDTO.email);
		user.setToken(token);
		user.setEnabled(true);
		
		Authority authority = new Authority();
		authority.setAuthority(Authorities.USER);
		authority.setUser(user);
		user.addAuthority(authority);
		
		return user;
	}
	
	private void saveUser(User user) {
		userCommandRepository.saveUser(user);
	}

}
