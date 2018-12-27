package com.jonathanperez.perspective.perspectivemodule.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;

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
		TypedQuery<Perspective> query = em.createQuery("from Perspective p where p.id = :id and p.isDeleted = false", Perspective.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}

	@Override
	public void savePerspective(Perspective perspective) {
		em.persist(perspective);
	}

	@Override
	public void updatePerspective(Perspective perspective) {
		em.merge(perspective);
	}

	@Override
	public Perspective findPerspectiveByTitle(String title) {
		TypedQuery<Perspective> query = em.createQuery("from Perspective p where p.title =:title and p.isDeleted = false", Perspective.class);
		query.setParameter("title", title);
		
		return query.getSingleResult();
	}

	@Override
	public Perspective findPerspectiveByTitle(String title, long idToExclude) {
		TypedQuery<Perspective> query = em.createQuery("from Perspective p where p.id !=:id and p.title =:title and p.isDeleted = false ", Perspective.class);
		query.setParameter("title", title);
		query.setParameter("id", idToExclude);
		
		return query.getSingleResult();
	}

}
