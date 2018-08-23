package com.jonathanperez.perspective.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.entities.Perspective;

@Repository
public class PerspectiveRepositoryImpl implements PerspectiveRepository{
	
	@PersistenceContext
	private EntityManager em;

 	@Override
	public List<Perspective> getPerspectives() {
 		Query query = em.createQuery("from Perspective p where p.isDeleted = false", Perspective.class);
 		List<Perspective> perspectives = query.getResultList();
 		
		return perspectives;
	}

	@Override
	public Perspective getPerspective(long id) {
		return em.find(Perspective.class, id);
	}

	@Override
	public void savePerspective(Perspective perspective) {
		em.persist(perspective);
	}

	@Override
	public void updatePerspective(Perspective perspective) {
		em.merge(perspective);
		
	}

}
