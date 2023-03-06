package com.blog.service;

import java.util.List;

import com.blog.model.User;
import com.blog.payloads.UserDTO;

public interface UserService {
	public UserDTO createUser(UserDTO userDto);
	public UserDTO updateUser(UserDTO userDto, Integer id);
	public UserDTO getUserById(Integer userId);
	public List<UserDTO> getAllUser();
	public void deleteUser(Integer userId);
}
