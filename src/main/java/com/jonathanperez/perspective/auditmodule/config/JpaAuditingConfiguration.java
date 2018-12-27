package com.jonathanperez.perspective.auditmodule.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.jonathanperez.perspective.util.UserSessionUtil;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {
	
	@Bean
	public AuditorAware<String> auditorProvider(){
		return () -> {
			return Optional.ofNullable(UserSessionUtil.getUsername());
		};
	}
}
