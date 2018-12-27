package com.jonathanperez.perspective.service;

import java.util.List;

import com.jonathanperez.perspective.entities.Category;

public interface CategoryService {
	
	public List<Category> getCategories();
	public Category getCategory(long id);
	public void createCategory(Category category);
	public Category updateCategory(Category category, long id);
	public void deleteCategory(long id);
	public boolean verifyUserCategoryNameExistance(String name, String username);
	public boolean verifyUserCategoryNameExistance(String name, String username, long idToExclude);
	
}
