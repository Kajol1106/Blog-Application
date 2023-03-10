package com.blog.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exception.ResourceNotFoundException;
import com.blog.model.Comment;
import com.blog.model.Post;
import com.blog.payloads.CommentDTO;
import com.blog.repository.CommentRepository;
import com.blog.repository.PostRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDTO createComment(CommentDTO commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundException("Post ", "post id", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDTO.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId)
				.orElseThrow(()-> new ResourceNotFoundException("Comment ", "comment id ", commentId));
		this.commentRepo.delete(comment);
		
	}

	@Override
	public CommentDTO updateComment(CommentDTO commentDto, Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId)
				.orElseThrow(()-> new ResourceNotFoundException("Comment ", "comment Id ", commentId));
		comment.setContent(commentDto.getContent());
		this.commentRepo.save(comment);
		return this.modelMapper.map(comment, CommentDTO.class);
	}

}
