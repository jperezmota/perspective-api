package com.jonathanperez.perspective.authormodule.repositories;

import java.util.List;

import com.jonathanperez.perspective.authormodule.entities.Author;
import com.jonathanperez.perspective.categorymodule.entities.Category;

public interface AuthorQueryRepository {
	public List<Author> getAuthors(String username);
	public Author getAuthor(long id, String username);
	public Author findUserAuthorByName(String name, String username);
	public Author findUserAuthorByName(String name, String username, long idToExclude);
}
