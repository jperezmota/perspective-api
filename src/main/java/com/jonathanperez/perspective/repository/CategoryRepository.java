package com.jonathanperez.perspective.repository;

import java.util.List;

import com.jonathanperez.perspective.entities.Category;

public interface CategoryRepository {	
	
	public List<Category> getCategories(String username);
	public Category getCategory(long id, String username);
	public void saveCategory(Category category);
	public void updateCategory(Category category);
	
}
