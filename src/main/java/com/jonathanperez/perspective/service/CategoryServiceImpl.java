package com.jonathanperez.perspective.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.dto.CategoryDTO;
import com.jonathanperez.perspective.entities.Category;
import com.jonathanperez.perspective.exception.ResourceNotFoundException;
import com.jonathanperez.perspective.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category getCategory(long id) {
		try {
			return categoryRepository.getCategory(id);
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Category", "Id", id);
		}	
	}

	@Override
	public List<Category> getCategories() {
		return categoryRepository.getCategories();
	}

	@Override
	public void createCategory(Category category) {
		category.setCreatedBy("admin");
		category.setCreatedDate(new Date());
		categoryRepository.saveCategory(category);
	}

	@Override
	public void deleteCategory(long id) {
		try {
			Category category = categoryRepository.getCategory(id);	
			category.setDeleted(true);
			category.setDeletedBy("admin");
			category.setDeletedDate(new Date());
			categoryRepository.updateCategory(category);
	 	}catch(EmptyResultDataAccessException ex) {
	 		throw new ResourceNotFoundException("Category", "Id", id);
	 	}
	}

	@Override
	public Category updateCategory(CategoryDTO categoryDTO, long id) {
		try {
			Category category = categoryRepository.getCategory(id);
			category.setName(categoryDTO.name);
			category.setLastModifiedBy("admin");
			category.setLastModifiedDate(new Date());
			categoryRepository.updateCategory(category);
			
			return category;
		}catch(EmptyResultDataAccessException ex) {
	 		throw new ResourceNotFoundException("Category", "Id", id);
	 	}
	}

}
