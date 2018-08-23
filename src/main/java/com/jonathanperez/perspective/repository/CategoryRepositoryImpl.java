package com.jonathanperez.perspective.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.entities.Category;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Category getCategory(long id) {
		return em.find(Category.class, id); 
	}

}
