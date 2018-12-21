package com.jonathanperez.perspective.repository;

import java.util.List;

import com.jonathanperez.perspective.entities.Perspective;

public interface PerspectiveRepository {
	 public List<Perspective> getPerspectives();
	 public Perspective getPerspective(long id);
	 public void savePerspective(Perspective perspective);
	 public void updatePerspective(Perspective perspective);
	 public Perspective findPerspectiveByTitle(String title);
	 public Perspective findPerspectiveByTitle(String title, long idToExclude);
}
