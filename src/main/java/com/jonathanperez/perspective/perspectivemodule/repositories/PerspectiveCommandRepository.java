package com.jonathanperez.perspective.perspectivemodule.repositories;

import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;

public interface PerspectiveCommandRepository {
	 public void savePerspective(Perspective perspective);
	 public void updatePerspective(Perspective perspective);
}
