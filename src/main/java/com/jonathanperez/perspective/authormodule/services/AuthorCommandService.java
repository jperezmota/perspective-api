package com.jonathanperez.perspective.authormodule.services;

import com.jonathanperez.perspective.authormodule.entities.Author;

public interface AuthorCommandService {
	public void createAuthor(Author author, String username);
	public Author updateAuthor(Author author, long id, String username);
	public void deleteAuthor(long id, String username);
}
