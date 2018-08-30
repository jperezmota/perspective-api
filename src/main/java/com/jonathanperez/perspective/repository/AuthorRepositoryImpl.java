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
	public Author getAuthor(long id) {
		TypedQuery<Author> query = em.createQuery("from Author a where a.id = :id and a.isDeleted = false", Author.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}

	@Override
	public List<Author> getAuthors() {
		Query query = em.createQuery("from Author a where a.isDeleted = false", Author.class);
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

}
