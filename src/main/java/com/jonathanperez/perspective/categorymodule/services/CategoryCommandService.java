package com.jonathanperez.perspective.categorymodule.services;

import com.jonathanperez.perspective.categorymodule.entities.Category;

public interface CategoryCommandService {
	
	public void createCategory(Category category);
	public Category updateCategory(Category category, long id);
	public void deleteCategory(long id);
	
}
