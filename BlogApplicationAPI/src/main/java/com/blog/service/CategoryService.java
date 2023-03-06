package com.blog.service;

import java.util.List;

import com.blog.payloads.CategoryDTO;

public interface CategoryService {

	//in interface bydefault access modifier is public
	//create
	public CategoryDTO createCategory(CategoryDTO categoryDto);
	
	//update
	public CategoryDTO updateCategory(CategoryDTO categoryDto, Integer categoryId);
	
	//delete
	public void deleteCategory(Integer categoryId);
	
	//get
	public CategoryDTO getCategory(Integer categoryId);
	
	//get all
	public List<CategoryDTO> getCategories();
}
