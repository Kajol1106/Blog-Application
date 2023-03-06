package com.blog.payloads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PostDTO {
	private Integer postId;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private UserDTO user;
	private CategoryDTO category;
	private List<CommentDTO> comments = new ArrayList<>();
}
