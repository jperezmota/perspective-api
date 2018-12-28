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


@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthorQueryRestController {
	
	@Autowired
	private AuthorQueryService authorQueryService;
	
	@GetMapping("/authors")
	public List<Author> getAuthors(){
		List<Author> authors = authorQueryService.getAuthors();
		return authors;
	}
	
	@GetMapping("/authors/{id}")
	public Author getAuthor(@PathVariable long id) {
		Author author = authorQueryService.getAuthor(id);		
		return author;
	}

}
