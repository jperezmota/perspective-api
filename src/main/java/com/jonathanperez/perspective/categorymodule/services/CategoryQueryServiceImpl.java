package com.jonathanperez.perspective.categorymodule.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.categorymodule.entities.Category;
import com.jonathanperez.perspective.categorymodule.repositories.CategoryQueryRepository;
import com.jonathanperez.perspective.sharedmodule.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class CategoryQueryServiceImpl implements CategoryQueryService {
	
	@Autowired
	private CategoryQueryRepository categoryQueryRepository;

	@Override
	public Category getCategory(long id, String username) {
		try {
			return categoryQueryRepository.getCategory(id, username);
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Category", "Id", id);
		}	
	}

	@Override
	public List<Category> getCategories(String username) {
		return categoryQueryRepository.getCategories(username);
	}
	
	@Override
	public boolean verifyUserCategoryNameExistance(String name, String username) {
		try{
			categoryQueryRepository.findUserCategoryByName(name, username);
			return true;
		}catch(EmptyResultDataAccessException ex) {
	 		return false;
	 	}	
	}
	
	@Override
	public boolean verifyUserCategoryNameExistance(String name, String username, long idToExclude) {
		try{
			categoryQueryRepository.findUserCategoryByName(name, username, idToExclude);
			return true;
		}
		catch(EmptyResultDataAccessException ex) {
	 		return false;
	 	}	
	}

}
