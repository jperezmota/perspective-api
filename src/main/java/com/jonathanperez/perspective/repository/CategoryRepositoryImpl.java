package com.jonathanperez.perspective.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.entities.Category;
import com.jonathanperez.perspective.entities.Perspective;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Category getCategory(long id) {
		TypedQuery<Category> query = em.createQuery("from Category c where c.id = :id and c.isDeleted = false", Category.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}

	@Override
	public List<Category> getCategories() {
		Query query = em.createQuery("from Category p where p.isDeleted = false", Category.class);
 		List<Category> categories = query.getResultList();
 		
		return categories;
	}

	@Override
	public void saveCategory(Category category) {
		em.persist(category);
	}

	@Override
	public void updateCategory(Category category) {
		em.merge(category);
	}

}
