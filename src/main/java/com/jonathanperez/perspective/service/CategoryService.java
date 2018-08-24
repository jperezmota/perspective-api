package com.jonathanperez.perspective.service;

import java.util.List;

import com.jonathanperez.perspective.dto.CategoryDTO;
import com.jonathanperez.perspective.entities.Category;

public interface CategoryService {
	
	public List<Category> getCategories();
	public Category getCategory(long id);
	public void createCategory(Category category);
	public Category updateCategory(CategoryDTO categoryDTO, long id);
	public void deleteCategory(long id);
	
}
