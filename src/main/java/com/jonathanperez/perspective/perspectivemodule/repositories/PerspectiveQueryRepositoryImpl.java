package com.jonathanperez.perspective.perspectivemodule.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;

@Repository
public class PerspectiveQueryRepositoryImpl implements PerspectiveQueryRepository{
	
	@PersistenceContext
	private EntityManager em;

 	@Override
	public List<Perspective> getPerspectives(String username) {
 		Query query = em.createQuery("from Perspective p where p.createdBy =:createdBy and p.isDeleted = false", Perspective.class);
 		query.setParameter("createdBy", username);
 		List<Perspective> perspectives = query.getResultList();
 		
		return perspectives;
	}

	@Override
	public Perspective getPerspective(long id, String username) {
		TypedQuery<Perspective> query = em.createQuery("from Perspective p where p.id = :id and p.createdBy =:createdBy and p.isDeleted = false", Perspective.class);
		query.setParameter("id", id);
		query.setParameter("createdBy", username);
		
		return query.getSingleResult();
	}

	@Override
	public Perspective findPerspectiveByTitle(String title, String username) {
		TypedQuery<Perspective> query = em.createQuery("from Perspective p where p.title =:title and p.createdBy =:createdBy and p.isDeleted = false", Perspective.class);
		query.setParameter("title", title);
		query.setParameter("createdBy", username);
		
		return query.getSingleResult();
	}

	@Override
	public Perspective findPerspectiveByTitle(String title, String username, long idToExclude) {
		TypedQuery<Perspective> query = em.createQuery("from Perspective p where p.id !=:id and p.title =:title and p.createdBy =:createdBy and p.isDeleted = false ", Perspective.class);
		query.setParameter("title", title);
		query.setParameter("id", idToExclude);
		query.setParameter("createdBy", username);
		
		return query.getSingleResult();
	}

}
