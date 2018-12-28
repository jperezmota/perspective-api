package com.jonathanperez.perspective.perspectivemodule.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanperez.perspective.perspectivemodule.dtos.PerspectiveDTO;
import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;
import com.jonathanperez.perspective.perspectivemodule.services.PerspectiveCommandService;
import com.jonathanperez.perspective.sharedmodule.session.UserSessionUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PerspectiveCommandRestController {
	
	@Autowired
	private PerspectiveCommandService perspectiveCommandService;
	
	@PostMapping("/perspectives")
	public Perspective createPerspective(@Valid @RequestBody PerspectiveDTO perspectiveDTO) {
		String usernameLogged = UserSessionUtil.getUsername();
		Perspective perspective = perspectiveCommandService.createPerspective(perspectiveDTO, usernameLogged);
		return perspective;	
	}
	
	@PatchMapping("/perspectives/{id}")
	public Perspective updatePerspective(@Valid @RequestBody PerspectiveDTO perspectiveDTO, @PathVariable long id) {
		String usernameLogged = UserSessionUtil.getUsername();
		return perspectiveCommandService.updatePerspective(perspectiveDTO, id, usernameLogged);
	}
	
	@DeleteMapping("/perspectives/{id}")
	public void deletePerspective(@PathVariable long id) {
		String usernameLogged = UserSessionUtil.getUsername();
		perspectiveCommandService.deletePerspective(id, usernameLogged);
	}

}
