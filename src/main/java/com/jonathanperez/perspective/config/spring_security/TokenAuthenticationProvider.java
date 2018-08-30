package com.jonathanperez.perspective.config.spring_security;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

import com.jonathanperez.perspective.entities.Authority;
import com.jonathanperez.perspective.entities.User;
import com.jonathanperez.perspective.repository.UserRepository;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
        		String userToken = authentication.getPrincipal().toString();
        		User user = userRepository.findUserByToken(userToken);
        		validateUser(user);
        		List<GrantedAuthority> grantedAuthorities = createGrantedAuthorities(user);
            
            return new UsernamePasswordAuthenticationToken(user.getUsername(), null, grantedAuthorities);
        }catch(EmptyResultDataAccessException ex) {
        		throw new UsernameNotFoundException("User not found.");
        }      
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(PreAuthenticatedAuthenticationToken.class);
	}
	
	private void validateUser(User user) {
		if(!user.isEnabled()) {
    			throw new DisabledException("User account is disabled.");
	    }
	    boolean userHasNotAuthorities = user.getAuthorities().size() == 0;
	    if(userHasNotAuthorities) {
	    		throw new RuntimeException("User has not authorities asigned.");
	    }
	}
	
	private List<GrantedAuthority> createGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
        for(Authority authority: user.getAuthorities()) 
        		authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        
        return authorities;
	}

}
