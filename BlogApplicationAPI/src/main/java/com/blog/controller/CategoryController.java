package com.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.CategoryDTO;
import com.blog.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	//create
	@PostMapping("/category")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO catDto) {
		CategoryDTO createdCat = this.categoryService.createCategory(catDto);
		return new ResponseEntity<CategoryDTO>(createdCat, HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/category/{id}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO catDto, @PathVariable(name = "id") Integer categoryId) {
		CategoryDTO updatedCat = this.categoryService.updateCategory(catDto, categoryId);
		return new ResponseEntity<CategoryDTO>(updatedCat, HttpStatus.ACCEPTED);
	}
	
	
	//delete
	@DeleteMapping("/category/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable(name = "id") Integer categoryId) {
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>(Map.of("Message ", "Category deleted"), HttpStatus.ACCEPTED);
	}
	
	
	//get
	@GetMapping("/category/{id}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable(name = "id") Integer id) {
		CategoryDTO category = this.categoryService.getCategory(id);
		return new ResponseEntity<CategoryDTO>(category, HttpStatus.OK);
	}
	
//	@GetMapping("/")
//	public ResponseEntity<List<CategoryDTO>> getAllCategory() {
//		List<CategoryDTO> users = this.categoryService.getCategories();
//		return new ResponseEntity<List<CategoryDTO>>(users, HttpStatus.OK);
//	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getCategories() {
		List<CategoryDTO> categories = this.categoryService.getCategories();
		return ResponseEntity.ok(categories);
	}
}
