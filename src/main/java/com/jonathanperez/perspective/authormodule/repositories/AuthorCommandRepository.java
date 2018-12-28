package com.jonathanperez.perspective.authormodule.repositories;

import java.util.List;

import com.jonathanperez.perspective.authormodule.entities.Author;
import com.jonathanperez.perspective.categorymodule.entities.Category;

public interface AuthorCommandRepository {
	public void saveAuthor(Author author);
	public void updateAuthor(Author author);
}
