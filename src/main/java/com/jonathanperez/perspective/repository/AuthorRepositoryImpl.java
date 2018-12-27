package com.jonathanperez.perspective.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.entities.Author;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Author getAuthor(long id, String username) {
		TypedQuery<Author> query = em.createQuery("from Author a where a.id = :id and a.createdBy = :createdBy and a.isDeleted = false", Author.class);
		query.setParameter("createdBy", username);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}

	@Override
	public List<Author> getAuthors(String username) {
		Query query = em.createQuery("from Author a where a.createdBy = :createdBy and a.isDeleted = false", Author.class);
		query.setParameter("createdBy", username);
 		List<Author> authors = query.getResultList();
 		
		return authors;
	}

	@Override
	public void saveAuthor(Author author) {
		em.persist(author);		
	}

	@Override
	public void updateAuthor(Author author) {
		em.merge(author);
	}

	@Override
	public Author findUserAuthorByName(String name, String username) {
		TypedQuery<Author> query = em.createQuery("from Author a where a.name =:name and a.createdBy =:createdBy and a.isDeleted = false", Author.class);
		query.setParameter("name", name);
		query.setParameter("createdBy", username);
		
		return query.getSingleResult();
	}

	@Override
	public Author findUserAuthorByName(String name, String username, long idToExclude) {
		TypedQuery<Author> query = em.createQuery("from Author a where a.id !=:id and a.name =:name and a.createdBy =:createdBy and a.isDeleted = false ", Author.class);
		query.setParameter("id", idToExclude);
		query.setParameter("name", name);
		query.setParameter("createdBy", username);
		
		return query.getSingleResult();
	}

}
