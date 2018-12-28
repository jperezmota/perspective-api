package com.jonathanperez.perspective.categorymodule.services;

import java.util.Date;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.categorymodule.entities.Category;
import com.jonathanperez.perspective.categorymodule.repositories.CategoryCommandRepository;
import com.jonathanperez.perspective.sharedmodule.exceptions.ResourceNotFoundException;
import com.jonathanperez.perspective.sharedmodule.session.UserSessionUtil;

@Service
@Transactional
public class CategoryCommandServiceImpl implements CategoryCommandService {
	
	@Autowired
	private CategoryCommandRepository categoryCommandRepository;
	@Autowired 
	private CategoryQueryService categoryQueryService;

	@Override
	public void createCategory(Category category) {
		boolean categoryNameAlreadyExists = categoryQueryService.verifyUserCategoryNameExistance(category.getName(), UserSessionUtil.getUsername());
		if(categoryNameAlreadyExists) {
			throw new ValidationException("Category name: " + category.getName() + ", already exists.");
		}
		
		categoryCommandRepository.saveCategory(category);
	}

	@Override
	public void deleteCategory(long id) {
		try {
			Category category = categoryQueryService.getCategory(id);
			category.setDeleted(true);
			category.setDeletedBy(UserSessionUtil.getUsername());
			category.setDeletedDate(new Date());
			
			categoryCommandRepository.updateCategory(category);
	 	}catch(ResourceNotFoundException ex) {
	 		throw ex;
	 	}
	}

	@Override
	public Category updateCategory(Category category, long id) {
		try {
			String username = UserSessionUtil.getUsername();
			Category existingCategory = categoryQueryService.getCategory(id);
			
			boolean categoryNameAlreadyExists = categoryQueryService.verifyUserCategoryNameExistance(category.getName(), username, id);
			if(categoryNameAlreadyExists) {
				throw new ValidationException("Category name: " + category.getName() + ", already exists.");
			}

			existingCategory.setName(category.getName());
			categoryCommandRepository.updateCategory(existingCategory);
			
			return existingCategory;
		}catch(ResourceNotFoundException ex) {
			throw ex;
	 	}
	}

}
