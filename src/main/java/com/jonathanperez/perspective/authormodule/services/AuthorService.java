package com.jonathanperez.perspective.authormodule.services;

import java.util.List;

import com.jonathanperez.perspective.authormodule.entities.Author;

public interface AuthorService {
	public List<Author> getAuthors();
	public Author getAuthor(long id);
	public void createAuthor(Author author);
	public Author updateAuthor(Author author, long id);
	public void deleteAuthor(long id);
	public boolean verifyUserAuthorNameExistance(String name, String username);
	public boolean verifyUserAuthorNameExistance(String name, String username, long idToExclude);
}
