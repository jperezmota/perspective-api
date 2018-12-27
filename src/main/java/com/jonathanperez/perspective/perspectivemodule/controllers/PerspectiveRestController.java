package com.jonathanperez.perspective.perspectivemodule.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanperez.perspective.perspectivemodule.dtos.PerspectiveDTO;
import com.jonathanperez.perspective.perspectivemodule.entities.Perspective;
import com.jonathanperez.perspective.perspectivemodule.services.PerspectiveService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PerspectiveRestController {
	
	@Autowired
	private PerspectiveService perspectiveService;
	
	@GetMapping("/perspectives")
	public List<Perspective> getPerspectives(){
		List<Perspective> perspectives = perspectiveService.getPerspectives();
		return perspectives;	
	}
	
	@GetMapping("/perspectives/{id}")
	public Perspective getPerspective(@PathVariable long id) {	
		Perspective perspective = perspectiveService.getPerspective(id);
		return perspective;	
	}
	
	@PostMapping("/perspectives")
	public Perspective createPerspective(@Valid @RequestBody PerspectiveDTO perspectiveDTO) {
		Perspective perspective = perspectiveService.createPerspective(perspectiveDTO);
		return perspective;	
	}
	
	@PatchMapping("/perspectives/{id}")
	public Perspective updatePerspective(@Valid @RequestBody PerspectiveDTO perspectiveDTO, @PathVariable long id) {
		return perspectiveService.updatePerspective(perspectiveDTO, id);
	}
	
	@DeleteMapping("/perspectives/{id}")
	public void deletePerspective(@PathVariable long id) {
		perspectiveService.deletePerspective(id);
	}

}
