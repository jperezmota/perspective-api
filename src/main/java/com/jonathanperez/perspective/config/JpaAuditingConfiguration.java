package com.jonathanperez.perspective.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {
	
	@Bean
	public AuditorAware<String> auditorProvider(){
		return () -> {
			String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
			return Optional.ofNullable(username);
		};
	}
}
