package com.jonathanperez.perspective.config.spring_security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.jonathanperez.perspective.filter.UserAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired 
	private TokenAuthenticationProvider tokenAuthenticationProvider;
	
   @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.authenticationProvider(tokenAuthenticationProvider);
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
	    	
	    	http.addFilterBefore(new UserAuthenticationFilter(), BasicAuthenticationFilter.class);
    }

}