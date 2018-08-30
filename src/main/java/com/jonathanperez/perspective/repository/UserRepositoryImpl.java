package com.jonathanperez.perspective.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.entities.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public User findUserByUsername(String username) {
		return em.find(User.class, username);
	}

	@Override
	public User findUserByToken(String token) {
		TypedQuery<User> typedQuery = em.createQuery("from User u where u.token = :token", User.class);
		typedQuery.setParameter("token", token);
		return typedQuery.getSingleResult();
	}

}
