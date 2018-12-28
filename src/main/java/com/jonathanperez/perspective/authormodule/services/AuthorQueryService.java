package com.jonathanperez.perspective.authormodule.services;

import java.util.List;

import com.jonathanperez.perspective.authormodule.entities.Author;

public interface AuthorQueryService {
	public List<Author> getAuthors();
	public Author getAuthor(long id);
	public boolean verifyUserAuthorNameExistance(String name, String username);
	public boolean verifyUserAuthorNameExistance(String name, String username, long idToExclude);
}
