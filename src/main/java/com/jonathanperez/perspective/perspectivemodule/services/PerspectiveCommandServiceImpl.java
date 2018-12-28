package com.jonathanperez.perspective.perspectivemodule.services;

import java.util.Date;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonathanperez.perspective.authormodule.services.AuthorQueryService;
import com.jonathanperez.perspective.categorymodule.services.CategoryQueryService;
import com.jonathanperez.perspective.perspectivemodule.dtos.PerspectiveDTO;
import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;
import com.jonathanperez.perspective.perspectivemodule.repositories.PerspectiveCommandRepository;

@Service
@Transactional
public class PerspectiveCommandServiceImpl implements PerspectiveCommandService {

	@Autowired
	private PerspectiveCommandRepository perspectiveCommandRepository;
	@Autowired
	private AuthorQueryService authorQueryService;
	@Autowired
	private CategoryQueryService categoryQueryService;
	@Autowired
	private PerspectiveQueryService perspectiveQueryService;

	@Override
	public Perspective createPerspective(PerspectiveDTO perspectiveDTO, String username) {
		boolean perspectiveTitleAlreadyExists = perspectiveQueryService.verifyPerspectiveTitleExistance(perspectiveDTO.title, username);
		if (perspectiveTitleAlreadyExists) {
			throw new ValidationException("Perspective title: " + perspectiveDTO.title + ", already exists.");
		}

		Perspective perspective = new Perspective();
		perspective.setTitle(perspectiveDTO.title);
		perspective.setPerspective(perspectiveDTO.perspective);
		perspective
				.setAuthor(perspectiveDTO.authorId == 0 ? null : authorQueryService.getAuthor(perspectiveDTO.authorId, username));
		perspective.setCategory(
				perspectiveDTO.categoryId == 0 ? null : categoryQueryService.getCategory(perspectiveDTO.categoryId, username));
		perspective.setThoughts(perspectiveDTO.thoughts);

		perspectiveCommandRepository.savePerspective(perspective);

		return perspective;
	}

	@Override
	public void deletePerspective(long id, String username) {
		Perspective perspective = perspectiveQueryService.getPerspective(id);
		perspective.setDeleted(true);
		perspective.setDeletedBy(username);
		perspective.setDeletedDate(new Date());
		perspectiveCommandRepository.updatePerspective(perspective);
	}

	@Override
	public Perspective updatePerspective(PerspectiveDTO perspectiveDTO, long id, String username) {
		boolean perspectiveTitleAlreadyExists = perspectiveQueryService
				.verifyPerspectiveTitleExistance(perspectiveDTO.title, username, id);
		if (perspectiveTitleAlreadyExists) {
			throw new ValidationException("Perspective title: " + perspectiveDTO.title + ", already exists.");
		}

		Perspective perspective = perspectiveQueryService.getPerspective(id);
		perspective.setTitle(perspectiveDTO.title);
		perspective.setPerspective(perspectiveDTO.perspective);
		perspective
				.setAuthor(perspectiveDTO.authorId == 0 ? null : authorQueryService.getAuthor(perspectiveDTO.authorId, username));
		perspective.setCategory(
				perspectiveDTO.categoryId == 0 ? null : categoryQueryService.getCategory(perspectiveDTO.categoryId, username));
		perspective.setThoughts(perspectiveDTO.thoughts);

		perspectiveCommandRepository.updatePerspective(perspective);

		return perspective;
	}

}
