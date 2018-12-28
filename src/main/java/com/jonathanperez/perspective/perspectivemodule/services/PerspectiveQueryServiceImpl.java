package com.jonathanperez.perspective.perspectivemodule.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;
import com.jonathanperez.perspective.perspectivemodule.repositories.PerspectiveQueryRepository;
import com.jonathanperez.perspective.sharedmodule.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class PerspectiveQueryServiceImpl implements PerspectiveQueryService{

	@Autowired
	private PerspectiveQueryRepository perspectiveQueryRepository;
	
	@Override
	public List<Perspective> getPerspectives(String username) {
		return perspectiveQueryRepository.getPerspectives(username);
	}

	@Override
	public Perspective getPerspective(long id, String username) {
		try {
			return perspectiveQueryRepository.getPerspective(id, username);
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Perspective", "Id", id);
		}	
	}

	@Override
	public boolean verifyPerspectiveTitleExistance(String title, String username) {
		try{
			perspectiveQueryRepository.findPerspectiveByTitle(title, username);
			return true;
		}
		catch(EmptyResultDataAccessException ex) {
	 		return false;
	 	}	
	}

	@Override
	public boolean verifyPerspectiveTitleExistance(String title, String username, long idToExclude) {
		try{
			perspectiveQueryRepository.findPerspectiveByTitle(title, username, idToExclude);
			return true;
		}
		catch(EmptyResultDataAccessException ex) {
	 		return false;
	 	}	
	}
	
}
