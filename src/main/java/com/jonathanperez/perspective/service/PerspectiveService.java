package com.jonathanperez.perspective.service;

import java.util.List;

import com.jonathanperez.perspective.dto.PerspectiveDTO;
import com.jonathanperez.perspective.entities.Perspective;

public interface PerspectiveService {
	
	public List<Perspective> getPerspectives();
	public Perspective getPerspective(long id);
	public Perspective createPerspective(PerspectiveDTO perspectiveDTO);
	public void deletePerspective(long id);
	public Perspective updatePerspective(PerspectiveDTO perspectiveDTO, long id);
	public boolean verifyPerspectiveTitleExistance(String title);
	public boolean verifyPerspectiveTitleExistance(String title, long idToExclude);
	
}
