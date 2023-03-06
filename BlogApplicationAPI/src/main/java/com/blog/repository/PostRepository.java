package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.model.Category;
import com.blog.model.Post;
import com.blog.model.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
	
	//u can use this if above not working with your hibernate version
//	@Query("select p from Post p where p.title like :key")
//	List<Post> findByTitle(@Param("key") String title);
}
