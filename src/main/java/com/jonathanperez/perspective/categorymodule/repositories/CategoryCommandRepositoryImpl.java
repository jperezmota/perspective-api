package com.jonathanperez.perspective.categorymodule.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.categorymodule.entities.Category;

@Repository
public class CategoryCommandRepositoryImpl implements CategoryCommandRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveCategory(Category category) {
		em.persist(category);
	}

	@Override
	public void updateCategory(Category category) {
		em.merge(category);
	}

}
