package com.jonathanperez.perspective.repository;

import java.util.List;

import com.jonathanperez.perspective.entities.Category;
import com.jonathanperez.perspective.entities.Perspective;

public interface CategoryRepository {	
	
	public List<Category> getCategories(String username);
	public Category getCategory(long id, String username);
	public void saveCategory(Category category);
	public void updateCategory(Category category);
	public Category findUserCategoryByName(String name, String username);
	public Category findUserCategoryByName(String name, String username, long idToExclude);
	
}
