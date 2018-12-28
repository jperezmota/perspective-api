package com.jonathanperez.perspective.perspectivemodule.services;

import com.jonathanperez.perspective.perspectivemodule.dtos.PerspectiveDTO;
import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;

public interface PerspectiveCommandService {
	
	public Perspective createPerspective(PerspectiveDTO perspectiveDTO, String username);
	public void deletePerspective(long id, String username);
	public Perspective updatePerspective(PerspectiveDTO perspectiveDTO, long id, String username);
	
}
