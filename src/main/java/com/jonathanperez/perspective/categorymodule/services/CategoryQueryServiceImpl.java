package com.jonathanperez.perspective.categorymodule.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jonathanperez.perspective.categorymodule.entities.Category;
import com.jonathanperez.perspective.categorymodule.repositories.CategoryQueryRepository;
import com.jonathanperez.perspective.sharedmodule.exceptions.ResourceNotFoundException;
import com.jonathanperez.perspective.sharedmodule.session.UserSessionUtil;

@Service
@Transactional
public class CategoryQueryServiceImpl implements CategoryQueryService {
	
	@Autowired
	private CategoryQueryRepository categoryQueryRepository;

	@Override
	public Category getCategory(long id) {
		try {
			return categoryQueryRepository.getCategory(id, UserSessionUtil.getUsername());
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Category", "Id", id);
		}	
	}

	@Override
	public List<Category> getCategories() {
		return categoryQueryRepository.getCategories(UserSessionUtil.getUsername());
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
