package com.jonathanperez.perspective.categorymodule.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonathanperez.perspective.categorymodule.entities.Category;
import com.jonathanperez.perspective.categorymodule.services.CategoryQueryService;
import com.jonathanperez.perspective.sharedmodule.session.UserSessionUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CategoryQueryRestController {
	
	@Autowired
	private CategoryQueryService categoryQueryService;
	
	@GetMapping("/categories")
	public List<Category> getCategories(){
		String usernameLogged = UserSessionUtil.getUsername();
		List<Category> categories = categoryQueryService.getCategories(usernameLogged);
		return categories;
	}
	
	@GetMapping("/categories/{id}")
	public Category getCategory(@PathVariable long id) {
		String usernameLogged = UserSessionUtil.getUsername();
		Category category = categoryQueryService.getCategory(id, usernameLogged);		
		return category;
	}

}
