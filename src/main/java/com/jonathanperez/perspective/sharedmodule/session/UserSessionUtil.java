package com.jonathanperez.perspective.sharedmodule.session;

import org.springframework.security.core.context.SecurityContextHolder;

public class UserSessionUtil {

	public static String getUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
	}
}
