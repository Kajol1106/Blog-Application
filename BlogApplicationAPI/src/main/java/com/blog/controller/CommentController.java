package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.exception.ApiResponse;
import com.blog.payloads.CommentDTO;
import com.blog.service.CommentService;

@RestController
@RequestMapping("api/posts/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	
	@PostMapping("/{postId}/comment")
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDto, @PathVariable Integer postId) {
		CommentDTO comment = this.commentService.createComment(commentDto, postId);
		return new ResponseEntity<CommentDTO>(comment, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>( new ApiResponse("comment deleted successfully ", true), HttpStatus.OK);
	}
	
	@PutMapping("/{commentId}")
	public ResponseEntity<CommentDTO> updateComment(@RequestBody CommentDTO commentDto, @PathVariable Integer commentId ) {
		CommentDTO updatedComment = this.commentService.updateComment(commentDto, commentId);
		return new ResponseEntity<CommentDTO>(updatedComment, HttpStatus.OK);
	}
}
