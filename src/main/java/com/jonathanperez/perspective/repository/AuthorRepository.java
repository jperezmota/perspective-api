package com.jonathanperez.perspective.repository;

import java.util.List;

import com.jonathanperez.perspective.entities.Author;

public interface AuthorRepository {
	public List<Author> getAuthors(String username);
	public Author getAuthor(long id, String username);
	public void saveAuthor(Author author);
	public void updateAuthor(Author author);
}
