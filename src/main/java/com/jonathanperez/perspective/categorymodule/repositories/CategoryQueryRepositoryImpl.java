package com.jonathanperez.perspective.categorymodule.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.categorymodule.entities.Category;

@Repository
public class CategoryQueryRepositoryImpl implements CategoryQueryRepository {
	
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
	public List<Category> getCategories(String username, String searchTerm) {
		String queryString = "from Category c where c.createdBy = :createdBy and c.isDeleted = false";
 		
 		boolean searchTermIsPresent = searchTerm != null;
 		if(searchTermIsPresent) {
 			queryString += " and concat(c.id, c.name) like '%" + searchTerm + "%'";	
 		}
 		
		Query query = em.createQuery(queryString, Category.class);
		query.setParameter("createdBy", username);
 		List<Category> categories = query.getResultList();
 		
		return categories;
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