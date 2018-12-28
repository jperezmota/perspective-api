package com.jonathanperez.perspective.perspectivemodule.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;
import com.jonathanperez.perspective.perspectivemodule.services.PerspectiveQueryService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PerspectiveQueryRestController {
	
	@Autowired
	private PerspectiveQueryService perspectiveQueryService;
	
	@GetMapping("/perspectives")
	public List<Perspective> getPerspectives(){
		List<Perspective> perspectives = perspectiveQueryService.getPerspectives();
		return perspectives;	
	}
	
	@GetMapping("/perspectives/{id}")
	public Perspective getPerspective(@PathVariable long id) {	
		Perspective perspective = perspectiveQueryService.getPerspective(id);
		return perspective;	
	}

}
