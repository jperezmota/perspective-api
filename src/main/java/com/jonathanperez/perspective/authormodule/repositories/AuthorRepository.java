package com.jonathanperez.perspective.authormodule.repositories;

import java.util.List;

import com.jonathanperez.perspective.authormodule.entities.Author;
import com.jonathanperez.perspective.entities.Category;

public interface AuthorRepository {
	public List<Author> getAuthors(String username);
	public Author getAuthor(long id, String username);
	public void saveAuthor(Author author);
	public void updateAuthor(Author author);
	public Author findUserAuthorByName(String name, String username);
	public Author findUserAuthorByName(String name, String username, long idToExclude);
}
