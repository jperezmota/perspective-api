package com.jonathanperez.perspective.categorymodule.repositories;

import java.util.List;

import com.jonathanperez.perspective.categorymodule.entities.Category;

public interface CategoryQueryRepository {	
	
	public List<Category> getCategories(String username, String searchTerm);
	public Category getCategory(long id, String username);
	public Category findUserCategoryByName(String name, String username);
	public Category findUserCategoryByName(String name, String username, long idToExclude);
	
}
