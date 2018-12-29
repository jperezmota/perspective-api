package com.jonathanperez.perspective.authormodule.services;

import java.util.List;

import com.jonathanperez.perspective.authormodule.entities.Author;

public interface AuthorQueryService {
	public List<Author> getAuthors(String username, String searchTerm);
	public Author getAuthor(long id, String username);
	public boolean verifyUserAuthorNameExistance(String name, String username);
	public boolean verifyUserAuthorNameExistance(String name, String username, long idToExclude);
}
