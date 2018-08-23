package com.jonathanperez.perspective.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.entities.Author;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Author getAuthor(long id) {
		return em.find(Author.class, id);
	}

}
