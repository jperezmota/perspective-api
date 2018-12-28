package com.jonathanperez.perspective.categorymodule.services;

import com.jonathanperez.perspective.categorymodule.entities.Category;

public interface CategoryCommandService {
	
	public void createCategory(Category category, String username);
	public Category updateCategory(Category category, long id, String username);
	public void deleteCategory(long id, String username);
	
}
