package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entities.User;
import com.blog.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable("userId") int userId) {
		
		
		
		return userService.getUser(userId);
		
	}
	
	@GetMapping("/users")
	public List<User> allUser() {
		
		
		
		return userService.allUser();
		
	}
	
	
	@PostMapping("/users")
	public User postUser(@RequestBody User user) {
		return userService.postUser(user)	;
		
	}
	
	@PutMapping("/users/userId")
	public User updateUser(@PathVariable("userId") int userId,@RequestBody User user) {
		return userService.updateUser(userId, user);
		
	}
	
	@DeleteMapping("/users/userId")
	public void deleteUser(@PathVariable("userId") int userId) {
		 userService.deleteUser(userId);
		
	}
	
}
