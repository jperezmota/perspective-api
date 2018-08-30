package com.jonathanperez.perspective.filter;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

public class UserAuthenticationFilter extends OncePerRequestFilter {
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		Authentication currentAuthentication = SecurityContextHolder.getContext().getAuthentication();
		if(currentAuthentication == null) {
			String userToken = request.getHeader("Authorization");
			Authentication preAuthenticatedAuthenticationToken = new PreAuthenticatedAuthenticationToken(userToken, null); 
			SecurityContextHolder.getContext().setAuthentication(preAuthenticatedAuthenticationToken);  
		}

		filterChain.doFilter(request, response);

	}

}
