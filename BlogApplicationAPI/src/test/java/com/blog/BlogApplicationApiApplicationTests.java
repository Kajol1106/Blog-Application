package com.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.repository.UserRepository;

@SpringBootTest
class BlogApplicationApiApplicationTests {

	/*
	 * Tested which implemented class will be created for userRepo
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void userRepoTest() {
		String classname = this.userRepo.getClass().getName();
		String packagename = this.userRepo.getClass().getPackageName();
		System.out.println(classname);
		System.out.println(packagename);
	}
	*/
	
	@Test
	void contextLoads() {
	}
	
	

}
