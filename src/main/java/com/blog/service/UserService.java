package com.blog.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.blog.entities.User;

public interface UserService {
	
	public User getUser(int userId);
	
	public List<User> allUser();

	public User postUser(User user);
	
	public User updateUser( int userId, User user);
	
	public void deleteUser(int userId);

}
