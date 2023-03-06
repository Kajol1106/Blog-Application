package com.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exception.ResourceNotFoundException;
import com.blog.model.Category;
import com.blog.payloads.CategoryDTO;
import com.blog.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ModelMapper modelMaper;
	
	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDto) {
		Category category = this.modelMaper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(category);
		return this.modelMaper.map(addedCat, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDto, Integer categoryId) {
		//find object is present or not
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category ", "Category id ", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		this.categoryRepo.save(category);
		return this.modelMaper.map(category, CategoryDTO.class);
		
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category ", "Category id ", categoryId));
		this.categoryRepo.delete(category);

	}

	@Override
	public CategoryDTO getCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category ", "category id ", categoryId));
		return this.modelMaper.map(category, CategoryDTO.class);
	}

	
	@Override
	public List<CategoryDTO> getCategories() {
		List<Category> list = this.categoryRepo.findAll();
		List<CategoryDTO> categoryDtos =  list.stream().map((category) -> this.modelMaper.map(category, CategoryDTO.class))
				.collect(Collectors.toList());
		return categoryDtos;
	}
	
	
//	public CategoryDTO categoryToDto(Category category) {
//		CategoryDTO categoryDto = this.categoryToDto(category);
//		return categoryDto;
//	}
//	
//	public Category dtoToCategory(CategoryDTO categoryDto) {
//		Category category = this.dtoToCategory(categoryDto);
//		return category;
//	}

}
