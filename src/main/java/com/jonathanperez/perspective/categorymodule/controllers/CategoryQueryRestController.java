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

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CategoryQueryRestController {
	
	@Autowired
	private CategoryQueryService categoryQueryService;
	
	@GetMapping("/categories")
	public List<Category> getCategories(){
		List<Category> categories = categoryQueryService.getCategories();
		return categories;
	}
	
	@GetMapping("/categories/{id}")
	public Category getCategory(@PathVariable long id) {
		Category category = categoryQueryService.getCategory(id);		
		return category;
	}

}
