package com.jonathanperez.perspective.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.entities.Category;
import com.jonathanperez.perspective.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category getCategory(long id) {
		return categoryRepository.getCategory(id);
	}

}
