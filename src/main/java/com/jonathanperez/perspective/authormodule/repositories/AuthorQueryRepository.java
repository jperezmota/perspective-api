package com.jonathanperez.perspective.authormodule.repositories;

import java.util.List;

import com.jonathanperez.perspective.authormodule.entities.Author;

public interface AuthorQueryRepository {
	public List<Author> getAuthors(String username, String searchTerm);
	public Author getAuthor(long id, String username);
	public Author findUserAuthorByName(String name, String username);
	public Author findUserAuthorByName(String name, String username, long idToExclude);
}
