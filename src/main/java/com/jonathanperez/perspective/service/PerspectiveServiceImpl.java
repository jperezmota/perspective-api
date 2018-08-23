package com.jonathanperez.perspective.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonathanperez.perspective.entities.Perspective;
import com.jonathanperez.perspective.repository.PerspectiveRepository;

@Service
@Transactional
public class PerspectiveServiceImpl implements PerspectiveService{

	@Autowired
	private PerspectiveRepository perspectiveRepository;
	
	@Override
	public List<Perspective> getPerspectives() {
		return perspectiveRepository.getPerspectives();
	}

	@Override
	public Perspective getPerspective(long id) {
		return perspectiveRepository.getPerspective(id);
	}

	@Override
	public void savePerspective(Perspective perspective) {
		perspectiveRepository.savePerspective(perspective);
	}

}
