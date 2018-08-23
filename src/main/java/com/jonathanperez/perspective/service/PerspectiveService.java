package com.jonathanperez.perspective.service;

import java.util.Collection;
import java.util.List;

import com.jonathanperez.perspective.entities.Perspective;

public interface PerspectiveService {
	
	public List<Perspective> getPerspectives();
	public Perspective getPerspective(long id);
	public void savePerspective(Perspective perspective);
	
}
