package com.blog.payloads;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class CategoryDTO {
	
	private Integer categoryId;
	
	
	private String categoryTitle;
	
	
	private String categoryDescription;
}
