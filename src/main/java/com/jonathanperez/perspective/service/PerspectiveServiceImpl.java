package com.jonathanperez.perspective.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonathanperez.perspective.dto.PerspectiveDTO;
import com.jonathanperez.perspective.entities.Perspective;
import com.jonathanperez.perspective.exception.ResourceNotFoundException;
import com.jonathanperez.perspective.repository.PerspectiveRepository;

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
		Perspective perspective = new Perspective();
		perspective.setPerspective(perspectiveDTO.perspective);
		perspective.setAuthor(perspectiveDTO.authorId == 0 ? null : authorService.getAuthor(perspectiveDTO.authorId));
		perspective.setCagetory(perspectiveDTO.categoryId == 0 ? null : categoryService.getCategory(perspectiveDTO.categoryId));
		perspective.setThoughts(perspectiveDTO.thoughts);
		perspective.setCreatedBy("admin");
		perspective.setCreatedDate(new Date());
		
		perspectiveRepository.savePerspective(perspective);
		
		return perspective;
	}

	@Override
	public void deletePerspective(long id) {
		try {
			Perspective perspective = perspectiveRepository.getPerspective(id);
			perspective.setDeleted(true);
			perspective.setDeletedBy("admin");
			perspective.setDeletedDate(new Date());
			perspectiveRepository.updatePerspective(perspective);
	 	}catch(EmptyResultDataAccessException ex) {
	 		throw new ResourceNotFoundException("Category", "Id", id);
	 	}	
	}

	@Override
	public Perspective updatePerspective(PerspectiveDTO perspectiveDTO, long id) {
		try {
			
			System.out.println("BAJANDO CON: " + id);
			Perspective perspective = perspectiveRepository.getPerspective(id);
			perspective.setPerspective(perspectiveDTO.perspective);
			perspective.setAuthor(perspectiveDTO.authorId == 0 ? null : authorService.getAuthor(perspectiveDTO.authorId));
			perspective.setCagetory(perspectiveDTO.categoryId == 0 ? null : categoryService.getCategory(perspectiveDTO.categoryId));
			perspective.setThoughts(perspectiveDTO.thoughts);
			perspective.setLastModifiedBy("admin");
			perspective.setLastModifiedDate(new Date());
			
			perspectiveRepository.updatePerspective(perspective);
			
			return perspective;
		}catch(EmptyResultDataAccessException ex) {
			System.out.println("TIRANDO CON: " + id);
	 		throw new ResourceNotFoundException("Perspective", "Id", id);
	 	}
	}
	
}
