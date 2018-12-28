package com.jonathanperez.perspective.authormodule.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanperez.perspective.authormodule.entities.Author;
import com.jonathanperez.perspective.authormodule.services.AuthorCommandService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthorCommandRestController {
	
	@Autowired
	private AuthorCommandService authorCommandService;
	
	@PostMapping("/authors")
	public Author createAuthor(@RequestBody Author author) {
		authorCommandService.createAuthor(author);
		return author;
	}
	
	@PatchMapping("/authors/{id}")
	public Author updateAuthor(@Valid @RequestBody Author author, @PathVariable long id) {
		return authorCommandService.updateAuthor(author, id);
	}
	
	@DeleteMapping("/authors/{id}")
	public void deleteAuthor(@PathVariable long id) {
		authorCommandService.deleteAuthor(id);
	}

}
