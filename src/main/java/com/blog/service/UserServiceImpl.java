package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.entities.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserService userService;

	@Override
	public User getUser(int userId) {
		
		return userService.getUser(userId);
	}

	@Override
	public List<User> allUser() {
		// TODO Auto-generated method stub
		return userService.allUser();
	}

	@Override
	public User postUser(User user) {
		// TODO Auto-generated method stub
		return userService.postUser(user);
	}

	@Override
	public User updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		return userService.updateUser(userId, user);
	}

	@Override
	public User deleteUser(int userId, User user) {
		// TODO Auto-generated method stub
		return deleteUser(userId, user);
	}

}
