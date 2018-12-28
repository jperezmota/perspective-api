package com.jonathanperez.perspective.authormodule.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanperez.perspective.authormodule.entities.Author;
import com.jonathanperez.perspective.authormodule.services.AuthorQueryService;
import com.jonathanperez.perspective.sharedmodule.session.UserSessionUtil;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthorQueryRestController {
	
	@Autowired
	private AuthorQueryService authorQueryService;
	
	@GetMapping("/authors")
	public List<Author> getAuthors(){
		String usernameLogged = UserSessionUtil.getUsername();
		List<Author> authors = authorQueryService.getAuthors(usernameLogged);
		return authors;
	}
	
	@GetMapping("/authors/{id}")
	public Author getAuthor(@PathVariable long id) {
		String usernameLogged = UserSessionUtil.getUsername();
		Author author = authorQueryService.getAuthor(id, usernameLogged);		
		return author;
	}

}
