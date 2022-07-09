package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.UserRepository;
import com.blog.entities.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@SuppressWarnings("deprecation")
	@Override
	public User getUser(int userId) {
		
		return userRepository.getById(userId);
	}

	@Override
	public List<User> allUser() {
	
		return userRepository.findAll();
	}

	@Override
	public User postUser(User user) {
	
		return userRepository.save(user);
	}

	@Override
	public User updateUser(int userId, User user) {
		
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(int userId) {
	
		 
		 userRepository.deleteById(userId);
	}


	

}
