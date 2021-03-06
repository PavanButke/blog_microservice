package com.blog.service;

import java.util.List;


import com.blog.dto.UserDto;
import com.blog.entities.User;


public interface UserService {
	
	public UserDto getUser(int userId);
	
	public List<UserDto> allUser(int pageNumber, int pageSize , boolean order , String... properties);

	public UserDto postUser(UserDto userDto);
	
	public UserDto updateUser( int userId, UserDto userDto);
	
	public void deleteUser(int userId);


	public List<UserDto> getByUserEmail(String userEmail);

}
