package com.jonathanperez.perspective.controller;

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

import com.jonathanperez.perspective.dto.CategoryDTO;
import com.jonathanperez.perspective.entities.Category;
import com.jonathanperez.perspective.service.CategoryService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CategoryRestController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> getCategories(){
		List<Category> categories = categoryService.getCategories();
		return categories;
	}
	
	@GetMapping("/categories/{id}")
	public Category getCategory(@PathVariable long id) {
		Category category = categoryService.getCategory(id);		
		return category;
	}
	
	@PostMapping("/categories")
	public Category createCategory(@RequestBody Category category) {
		categoryService.createCategory(category);
		return category;
	}
	
	@PatchMapping("/categories/{id}")
	public Category updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable long id) {
		return categoryService.updateCategory(categoryDTO, id);
	}
	
	@DeleteMapping("/categories/{id}")
	public void deleteCategory(@PathVariable long id) {
		categoryService.deleteCategory(id);
	}

}
