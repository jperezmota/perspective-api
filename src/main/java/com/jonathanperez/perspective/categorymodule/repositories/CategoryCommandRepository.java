package com.jonathanperez.perspective.categorymodule.repositories;

import com.jonathanperez.perspective.categorymodule.entities.Category;

public interface CategoryCommandRepository {	
	
	public void saveCategory(Category category);
	public void updateCategory(Category category);
	
}
