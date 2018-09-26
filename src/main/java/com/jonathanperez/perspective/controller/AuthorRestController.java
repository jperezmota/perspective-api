package com.jonathanperez.perspective.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanperez.perspective.dto.AuthorDTO;
import com.jonathanperez.perspective.entities.Author;
import com.jonathanperez.perspective.service.AuthorService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthorRestController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/authors")
	public List<Author> getAuthors(){
		List<Author> authors = authorService.getAuthors();
		return authors;
	}
	
	@GetMapping("/authors/{id}")
	public Author getAuthor(@PathVariable long id) {
		Author author = authorService.getAuthor(id);		
		return author;
	}
	
	@PostMapping("/authors")
	public Author createAuthor(@RequestBody Author author) {
		authorService.createAuthor(author);
		return author;
	}
	
	@PatchMapping("/authors/{id}")
	public Author updateAuthor(@Valid @RequestBody AuthorDTO authorDTO, @PathVariable long id) {
		return authorService.updateAuthor(authorDTO, id);
	}
	
	@DeleteMapping("/authors/{id}")
	public void deleteAuthor(@PathVariable long id) {
		authorService.deleteAuthor(id);
	}

}
