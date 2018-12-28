package com.jonathanperez.perspective.usermodule.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.usermodule.entities.User;

@Repository
public class UserCommandRepositoryImpl implements UserCommandRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveUser(User user) {
		em.persist(user);
	}
	
	@Override
	public void updateUser(User user) {
		em.merge(user);
	}

}
