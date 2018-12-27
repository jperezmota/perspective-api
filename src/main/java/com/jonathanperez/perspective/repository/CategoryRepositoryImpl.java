package com.jonathanperez.perspective.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.entities.Category;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Category getCategory(long id, String username) {
		TypedQuery<Category> query = em.createQuery("from Category c where c.id = :id and c.createdBy = :createdBy and c.isDeleted = false", Category.class);
		query.setParameter("id", id);
		query.setParameter("createdBy", username);
		
		return query.getSingleResult();
	}

	@Override
	public List<Category> getCategories(String username) {
		Query query = em.createQuery("from Category c where c.createdBy = :createdBy and c.isDeleted = false", Category.class);
		query.setParameter("createdBy", username);
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

	@Override
	public Category findUserCategoryByName(String name, String username) {
		TypedQuery<Category> query = em.createQuery("from Category c where c.name =:name and c.createdBy =:createdBy and c.isDeleted = false", Category.class);
		query.setParameter("name", name);
		query.setParameter("createdBy", username);
		
		return query.getSingleResult();
	}

	@Override
	public Category findUserCategoryByName(String name, String username, long idToExclude) {
		TypedQuery<Category> query = em.createQuery("from Category c where c.id !=:id and c.name =:name and c.createdBy =:createdBy and c.isDeleted = false ", Category.class);
		query.setParameter("id", idToExclude);
		query.setParameter("name", name);
		query.setParameter("createdBy", username);
		
		return query.getSingleResult();
	}

}
