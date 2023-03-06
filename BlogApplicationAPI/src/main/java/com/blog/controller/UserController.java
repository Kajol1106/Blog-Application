package com.blog.controller;

import java.util.List;
import java.util.Map;


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
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.UserDTO;
import com.blog.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDto) {
		UserDTO savedUser = this.userService.createUser(userDto);
		return new ResponseEntity<UserDTO>(savedUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto, @PathVariable Integer id) {
		UserDTO updatedUser = this.userService.updateUser(userDto, id);
		return new ResponseEntity<UserDTO>(updatedUser, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO> getUserByID(@PathVariable Integer id) {
		UserDTO user = this.userService.getUserById(id);
		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Integer id) {
		this.userService.deleteUser(id);
		return new ResponseEntity<>(Map.of("Message", "User deleted"), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> users = this.userService.getAllUser();
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
	}
}
