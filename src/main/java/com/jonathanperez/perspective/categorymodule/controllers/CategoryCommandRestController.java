package com.jonathanperez.perspective.categorymodule.controllers;

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

import com.jonathanperez.perspective.categorymodule.entities.Category;
import com.jonathanperez.perspective.categorymodule.services.CategoryCommandService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CategoryCommandRestController {
	
	@Autowired
	private CategoryCommandService categoryService;
	
	@PostMapping("/categories")
	public Category createCategory(@RequestBody Category category) {
		categoryService.createCategory(category);
		return category;
	}
	
	@PatchMapping("/categories/{id}")
	public Category updateCategory(@Valid @RequestBody Category category, @PathVariable long id) {
		return categoryService.updateCategory(category, id);
	}
	
	@DeleteMapping("/categories/{id}")
	public void deleteCategory(@PathVariable long id) {
		categoryService.deleteCategory(id);
	}

}
