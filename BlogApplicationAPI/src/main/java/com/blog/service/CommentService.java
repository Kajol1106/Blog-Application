package com.blog.service;

import com.blog.payloads.CommentDTO;

public interface CommentService {
	public CommentDTO createComment(CommentDTO commentDto, Integer postId);
	public void deleteComment(Integer commentId);
	public CommentDTO updateComment(CommentDTO commentDto, Integer commentId);
}
