package com.jonathanperez.perspective.categorymodule.services;

import java.util.List;

import com.jonathanperez.perspective.categorymodule.entities.Category;

public interface CategoryQueryService {
	
	public List<Category> getCategories(String username);
	public Category getCategory(long id, String username);
	public boolean verifyUserCategoryNameExistance(String name, String username);
	public boolean verifyUserCategoryNameExistance(String name, String username, long idToExclude);
	
}
