package com.jonathanperez.perspective.categorymodule.services;

import java.util.List;

import com.jonathanperez.perspective.categorymodule.entities.Category;

public interface CategoryQueryService {
	
	public List<Category> getCategories();
	public Category getCategory(long id);
	public boolean verifyUserCategoryNameExistance(String name, String username);
	public boolean verifyUserCategoryNameExistance(String name, String username, long idToExclude);
	
}
