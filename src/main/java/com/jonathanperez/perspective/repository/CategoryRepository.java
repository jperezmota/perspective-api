package com.jonathanperez.perspective.repository;

import java.util.List;

import com.jonathanperez.perspective.entities.Category;
import com.jonathanperez.perspective.entities.Perspective;

public interface CategoryRepository {	
	
	public List<Category> getCategories();
	public Category getCategory(long id);
	public void saveCategory(Category category);
	public void updateCategory(Category category);
	
}
