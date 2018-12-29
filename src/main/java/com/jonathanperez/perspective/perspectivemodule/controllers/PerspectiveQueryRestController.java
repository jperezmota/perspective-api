package com.jonathanperez.perspective.perspectivemodule.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;
import com.jonathanperez.perspective.perspectivemodule.services.PerspectiveQueryService;
import com.jonathanperez.perspective.sharedmodule.session.UserSessionUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PerspectiveQueryRestController {
	
	@Autowired
	private PerspectiveQueryService perspectiveQueryService;
	
	@GetMapping("/perspectives")
	public List<Perspective> getPerspectives(@RequestParam(required = false) String searchTerm){
		String usernameLogged = UserSessionUtil.getUsername();
		List<Perspective> perspectives = perspectiveQueryService.getPerspectives(usernameLogged, searchTerm);
		return perspectives;	
	}
	
	@GetMapping("/perspectives/{id}")
	public Perspective getPerspective(@PathVariable long id) {	
		String usernameLogged = UserSessionUtil.getUsername();
		Perspective perspective = perspectiveQueryService.getPerspective(id, usernameLogged);
		return perspective;	
	}

}
