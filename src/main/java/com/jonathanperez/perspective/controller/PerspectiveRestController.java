package com.jonathanperez.perspective.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanperez.perspective.entities.Perspective;
import com.jonathanperez.perspective.exception.ResourceNotFoundException;
import com.jonathanperez.perspective.service.PerspectiveService;
import com.jonathanperez.perspective.service.PerspectiveServiceImpl;

@RestController
@RequestMapping("/api")
public class PerspectiveRestController {
	
	@Autowired
	private PerspectiveService perspectiveService;
	
	@GetMapping("/perspectives")
	public List<Perspective> getPerspectives(){
		List<Perspective> pers = perspectiveService.getPerspectives();

		return pers;
	}
	
	@GetMapping("/perspectives/{perspectiveId}")
	public Perspective getPerspective(@PathVariable long perspectiveId) {
		
		Perspective perspective = perspectiveService.getPerspective(perspectiveId);
		System.out.println(perspective);
		
		if(perspective == null) {
			throw new ResourceNotFoundException("Perspesctive", "Id", perspectiveId);
		}
		
		return perspective;
	}
	
	@PostMapping("/perspectives")
	public Perspective createPerspective(@RequestBody Perspective perspective) {
		System.out.println(perspective.toString());
		perspective.setCreatedBy("admin");
		perspective.setCreatedDate(new Date());
		perspectiveService.savePerspective(perspective);
		return perspective;
	}

}
