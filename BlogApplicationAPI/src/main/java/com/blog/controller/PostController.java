package com.blog.controller;

 import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.config.AppConstants;
import com.blog.exception.ApiResponse;
import com.blog.payloads.PostDTO;
import com.blog.payloads.PostResponse;
import com.blog.service.PostService;

@RestController
@RequestMapping("api/")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDTO> createPost(
			@RequestBody PostDTO postDto, 
			@PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		PostDTO createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDTO>(createPost, HttpStatus.CREATED);
	}
	
	@GetMapping("/posts/post/{postId}")
	public ResponseEntity<PostDTO> getPost(@PathVariable Integer postId) {
		PostDTO post = this.postService.getPost(postId);
		return new ResponseEntity<PostDTO>(post, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("category/{categoryId}/posts")
	public ResponseEntity<List<PostDTO>> getAllPostsByCategory( @PathVariable Integer categoryId) {
		List<PostDTO> posts = this.postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDTO>>(posts, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("user/{userID}/posts")
	public ResponseEntity<List<PostDTO>> getAllPostByUser(@PathVariable Integer userID) {
		List<PostDTO> posts = this.postService.getPostByUser(userID);
		return new ResponseEntity<List<PostDTO>>(posts, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("posts/post/{postId}")
	public ApiResponse deletePostById(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("post deleted successfully ", true);
	}
	
	@PutMapping("posts/post/{postId}")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO dto, @PathVariable Integer postId) {
		PostDTO post = this.postService.updatePost(dto, postId);
		return new ResponseEntity<PostDTO>(post, HttpStatus.OK);
	}
	
	//we can implement below methods in one method. just for understanding purpose i implement different methods for different topic
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostDTO>> getAllPosts() {
		List<PostDTO> posts = this.postService.getAllPosts();
		return new ResponseEntity<List<PostDTO>>(posts, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/postsUsingPagination")
	public ResponseEntity<List<PostDTO>> getAllPostsByPagination(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber, 
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize) {
		List<PostDTO> posts = this.postService.getAllPostUsingPagination(pageNumber, pageSize);
		return new ResponseEntity<List<PostDTO>>(posts, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/posts/postResponse")
	public ResponseEntity<PostResponse> getAllPostsByPaginationResponse(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber, 
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize) {
		PostResponse posts = this.postService.getAllPostResponse(pageNumber, pageSize);
		return new ResponseEntity<PostResponse>(posts, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/posts/postResponseUsingSorting")
	public ResponseEntity<PostResponse> getAllPostsByPaginationResponseWithSorting(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber, 
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy, 
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {
		PostResponse posts = this.postService.getAllPostResponseBySortingWithPagination(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostResponse>(posts, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("posts/search/{keywords}")
	public ResponseEntity<List<PostDTO>> searchPostByTitle(@PathVariable("keywords") String keywords) {
		List<PostDTO> res = this.postService.searchPost(keywords);
		return new ResponseEntity<List<PostDTO>>(res, HttpStatus.OK);
	}
	
	
}
