package com.jonathanperez.perspective.perspectivemodule.services;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonathanperez.perspective.authormodule.services.AuthorService;
import com.jonathanperez.perspective.categorymodule.services.CategoryService;
import com.jonathanperez.perspective.exception.ResourceNotFoundException;
import com.jonathanperez.perspective.perspectivemodule.dtos.PerspectiveDTO;
import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;
import com.jonathanperez.perspective.perspectivemodule.repositories.PerspectiveRepository;
import com.jonathanperez.perspective.util.UserSessionUtil;

@Service
@Transactional
public class PerspectiveServiceImpl implements PerspectiveService{

	@Autowired
	private PerspectiveRepository perspectiveRepository;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private CategoryService categoryService;
	
	@Override
	public List<Perspective> getPerspectives() {
		return perspectiveRepository.getPerspectives();
	}

	@Override
	public Perspective getPerspective(long id) {
		try {
			return perspectiveRepository.getPerspective(id);
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Perspective", "Id", id);
		}	
	}

	@Override
	public Perspective createPerspective(PerspectiveDTO perspectiveDTO) {
		boolean perspectiveTitleAlreadyExists = verifyPerspectiveTitleExistance(perspectiveDTO.title);
		if(perspectiveTitleAlreadyExists) {
			throw new ValidationException("Perspective title: "+ perspectiveDTO.title+", already exists.");
		}
		
		Perspective perspective = new Perspective();
		perspective.setTitle(perspectiveDTO.title);
		perspective.setPerspective(perspectiveDTO.perspective);
		perspective.setAuthor(perspectiveDTO.authorId == 0 ? null : authorService.getAuthor(perspectiveDTO.authorId));
		perspective.setCategory(perspectiveDTO.categoryId == 0 ? null : categoryService.getCategory(perspectiveDTO.categoryId));
		perspective.setThoughts(perspectiveDTO.thoughts);
		
		perspectiveRepository.savePerspective(perspective);
		
		return perspective;
	}

	@Override
	public void deletePerspective(long id) {
		try {
			Perspective perspective = perspectiveRepository.getPerspective(id);
			perspective.setDeleted(true);
			perspective.setDeletedBy(UserSessionUtil.getUsername());
			perspective.setDeletedDate(new Date());
			perspectiveRepository.updatePerspective(perspective);
	 	}catch(EmptyResultDataAccessException ex) {
	 		throw new ResourceNotFoundException("Perspective", "Id", id);
	 	}	
	}

	@Override
	public Perspective updatePerspective(PerspectiveDTO perspectiveDTO, long id) {
		try {
			boolean perspectiveTitleAlreadyExists = verifyPerspectiveTitleExistance(perspectiveDTO.title, id);
			if(perspectiveTitleAlreadyExists) {
				throw new ValidationException("Perspective title: "+ perspectiveDTO.title+", already exists.");
			}
			
			Perspective perspective = perspectiveRepository.getPerspective(id);
			perspective.setPerspective(perspectiveDTO.perspective);
			perspective.setAuthor(perspectiveDTO.authorId == 0 ? null : authorService.getAuthor(perspectiveDTO.authorId));
			perspective.setCategory(perspectiveDTO.categoryId == 0 ? null : categoryService.getCategory(perspectiveDTO.categoryId));
			perspective.setThoughts(perspectiveDTO.thoughts);
			
			perspectiveRepository.updatePerspective(perspective);
			
			return perspective;
		}catch(EmptyResultDataAccessException ex) {
	 		throw new ResourceNotFoundException("Perspective", "Id", id);
	 	}
	}

	@Override
	public boolean verifyPerspectiveTitleExistance(String title) {
		try{
			perspectiveRepository.findPerspectiveByTitle(title);
			return true;
		}
		catch(EmptyResultDataAccessException ex) {
	 		return false;
	 	}	
	}

	@Override
	public boolean verifyPerspectiveTitleExistance(String title, long idToExclude) {
		try{
			perspectiveRepository.findPerspectiveByTitle(title, idToExclude);
			return true;
		}
		catch(EmptyResultDataAccessException ex) {
	 		return false;
	 	}	
	}
	
}
