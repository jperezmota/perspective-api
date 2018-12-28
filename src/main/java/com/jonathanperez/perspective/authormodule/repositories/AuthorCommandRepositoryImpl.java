package com.jonathanperez.perspective.authormodule.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.authormodule.entities.Author;

@Repository
public class AuthorCommandRepositoryImpl implements AuthorCommandRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveAuthor(Author author) {
		em.persist(author);		
	}

	@Override
	public void updateAuthor(Author author) {
		em.merge(author);
	}

}
