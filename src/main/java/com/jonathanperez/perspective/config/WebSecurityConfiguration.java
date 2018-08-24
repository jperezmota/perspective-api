package com.jonathanperez.perspective.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
   @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("admin").password("admin").roles("ADMIN"))
			.withUser(users.username("user").password("user").roles("USER"));
	}
  
	   
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	    	http.authorizeRequests()
	    		.antMatchers("/api/securities/**").permitAll()
            .anyRequest().authenticated()
			.and()
			  .httpBasic()
			.and()
			  .csrf().disable()
			  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}