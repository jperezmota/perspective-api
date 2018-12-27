package com.jonathanperez.perspective.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.entities.Category;
import com.jonathanperez.perspective.exception.ResourceNotFoundException;
import com.jonathanperez.perspective.repository.CategoryRepository;
import com.jonathanperez.perspective.util.UserSessionUtil;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category getCategory(long id) {
		try {
			return categoryRepository.getCategory(id, UserSessionUtil.getUsername());
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Category", "Id", id);
		}	
	}

	@Override
	public List<Category> getCategories() {
		return categoryRepository.getCategories(UserSessionUtil.getUsername());
	}

	@Override
	public void createCategory(Category category) {
		boolean categoryNameAlreadyExists = verifyUserCategoryNameExistance(category.getName(), UserSessionUtil.getUsername());
		if(categoryNameAlreadyExists) {
			throw new ValidationException("Category name: " + category.getName() + ", already exists.");
		}
		
		categoryRepository.saveCategory(category);
	}

	@Override
	public void deleteCategory(long id) {
		try {
			Category category = categoryRepository.getCategory(id, UserSessionUtil.getUsername());	
			category.setDeleted(true);
			category.setDeletedBy(UserSessionUtil.getUsername());
			category.setDeletedDate(new Date());
			
			categoryRepository.updateCategory(category);
	 	}catch(EmptyResultDataAccessException ex) {
	 		throw new ResourceNotFoundException("Category", "Id", id);
	 	}
	}

	@Override
	public Category updateCategory(Category category, long id) {
		try {
			String username = UserSessionUtil.getUsername();
			Category existingCategory = categoryRepository.getCategory(id, UserSessionUtil.getUsername());
			
			boolean categoryNameAlreadyExists = verifyUserCategoryNameExistance(category.getName(), username, id);
			if(categoryNameAlreadyExists) {
				throw new ValidationException("Category name: " + category.getName() + ", already exists.");
			}

			existingCategory.setName(category.getName());
			categoryRepository.updateCategory(existingCategory);
			
			return existingCategory;
		}catch(EmptyResultDataAccessException ex) {
	 		throw new ResourceNotFoundException("Category", "Id", id);
	 	}
	}
	
	@Override
	public boolean verifyUserCategoryNameExistance(String name, String username) {
		try{
			categoryRepository.findUserCategoryByName(name, username);
			return true;
		}catch(EmptyResultDataAccessException ex) {
	 		return false;
	 	}	
	}
	
	@Override
	public boolean verifyUserCategoryNameExistance(String name, String username, long idToExclude) {
		try{
			categoryRepository.findUserCategoryByName(name, username, idToExclude);
			return true;
		}
		catch(EmptyResultDataAccessException ex) {
	 		return false;
	 	}	
	}

}
