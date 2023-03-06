package com.blog.service;

import java.util.List;

import com.blog.model.Post;
import com.blog.payloads.PostDTO;
import com.blog.payloads.PostResponse;

public interface PostService {

	//create post
	public PostDTO createPost(PostDTO postDto, Integer userId, Integer categoryId);
	
	//update post
	public PostDTO updatePost(PostDTO postDto, Integer postId);
	
	//delete post
	public void deletePost(Integer postId);
	
	//get single post
	public PostDTO getPost(Integer postId);
	
	//get list of post
	public List<PostDTO> getAllPosts();
	
	//get list of post using pagination
	public List<PostDTO> getAllPostUsingPagination(Integer pageNumber, Integer pageSize);
	
	public PostResponse getAllPostResponse(Integer pageNumber, Integer pageSize);
	
	public PostResponse getAllPostResponseBySortingWithPagination(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	//get all posts by category
	public List<PostDTO> getPostByCategory(Integer categoryId);
	
	//get all posts by user
	public List<PostDTO> getPostByUser(Integer userId);
	
	//search post or get post by keyword
	public List<PostDTO> searchPost(String keyword);
	
}
