package com.jonathanperez.perspective.perspectivemodule.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;

@Repository
public class PerspectiveCommandRepositoryImpl implements PerspectiveCommandRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void savePerspective(Perspective perspective) {
		em.persist(perspective);
	}

	@Override
	public void updatePerspective(Perspective perspective) {
		em.merge(perspective);
	}

}
