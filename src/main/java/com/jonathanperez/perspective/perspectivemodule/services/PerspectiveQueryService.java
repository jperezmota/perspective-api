package com.jonathanperez.perspective.perspectivemodule.services;

import java.util.List;

import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;

public interface PerspectiveQueryService {
	
	public List<Perspective> getPerspectives(String username, String searchTerm);
	public Perspective getPerspective(long id, String username);
	public boolean verifyPerspectiveTitleExistance(String title, String username);
	public boolean verifyPerspectiveTitleExistance(String title, String username, long idToExclude);
	
}
