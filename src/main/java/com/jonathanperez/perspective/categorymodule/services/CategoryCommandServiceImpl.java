package com.jonathanperez.perspective.categorymodule.services;

import java.util.Date;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.categorymodule.entities.Category;
import com.jonathanperez.perspective.categorymodule.repositories.CategoryCommandRepository;

@Service
@Transactional
public class CategoryCommandServiceImpl implements CategoryCommandService {

	@Autowired
	private CategoryCommandRepository categoryCommandRepository;
	@Autowired
	private CategoryQueryService categoryQueryService;

	@Override
	public void createCategory(Category category, String username) {
		boolean categoryNameAlreadyExists = categoryQueryService.verifyUserCategoryNameExistance(category.getName(),
				 username);
		if (categoryNameAlreadyExists) {
			throw new ValidationException("Category name: " + category.getName() + ", already exists.");
		}

		categoryCommandRepository.saveCategory(category);
	}

	@Override
	public void deleteCategory(long id, String username) {

		Category category = categoryQueryService.getCategory(id, username);
		category.setDeleted(true);
		category.setDeletedBy(username);
		category.setDeletedDate(new Date());

		categoryCommandRepository.updateCategory(category);

	}

	@Override
	public Category updateCategory(Category category, long id, String username) {
		Category existingCategory = categoryQueryService.getCategory(id, username);

		boolean categoryNameAlreadyExists = categoryQueryService.verifyUserCategoryNameExistance(category.getName(),
				username, id);
		if (categoryNameAlreadyExists) {
			throw new ValidationException("Category name: " + category.getName() + ", already exists.");
		}

		existingCategory.setName(category.getName());
		categoryCommandRepository.updateCategory(existingCategory);

		return existingCategory;
	}

}
