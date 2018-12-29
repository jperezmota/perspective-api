package com.jonathanperez.perspective.perspectivemodule.repositories;

import java.util.List;

import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;

public interface PerspectiveQueryRepository {
	 public List<Perspective> getPerspectives(String username, String searchTerm);
	 public Perspective getPerspective(long id, String username);
	 public Perspective findPerspectiveByTitle(String title, String username);
	 public Perspective findPerspectiveByTitle(String title, String username, long idToExclude);
}
