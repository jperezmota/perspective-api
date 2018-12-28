package com.jonathanperez.perspective.authormodule.services;

import com.jonathanperez.perspective.authormodule.entities.Author;

public interface AuthorCommandService {
	public void createAuthor(Author author);
	public Author updateAuthor(Author author, long id);
	public void deleteAuthor(long id);
}
