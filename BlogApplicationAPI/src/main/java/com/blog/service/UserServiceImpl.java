package com.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exception.ResourceNotFoundException;
import com.blog.model.User;
import com.blog.payloads.UserDTO;
import com.blog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDTO createUser(UserDTO userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto, Integer id) {
		User user = this.userRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		UserDTO userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUser() {
		List<User> users = this.userRepo.findAll();
		List<UserDTO> userDtos =  users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		this.userRepo.delete(user);
	}
	
	/*
	 * 
	 *Doing this (conver object to dto and dto to object) 
	 *work manually it will be very hectic if our project big
	 *for this we can use model wrapper dependency to do our work easy
	 
	 
	private User dtoToUser(UserDTO userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		return user;
	}
	
	public UserDTO userToDto(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setAbout(user.getAbout());
		userDto.setEmail(user.getEmail());
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());
		return userDto;
	}
	*/
	
	public User dtoToUser(UserDTO userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;
	}
	
	public UserDTO userToDto(User user) {
		UserDTO userDto = this.modelMapper.map(user, UserDTO.class);
		return userDto;
	}
	

}
