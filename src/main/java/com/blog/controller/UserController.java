package com.blog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.blog.entities.User;

@Controller
public class UserController {
	
	

	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable("userId") int userId) {
		
		
		
		return null;
		
	}
	
	@GetMapping("/users")
	public List<User> allUser() {
		
		
		
		return null;
		
	}
	
	
	@PostMapping("/users")
	public User postUser(@RequestBody User user) {
		return user;
		
	}
	
	@PutMapping("/users/userId")
	public User updateUser(@PathVariable("userId") int userId,@RequestBody User user) {
		return user;
		
	}
	
	@DeleteMapping("/users/userId")
	public User deleteUser(@PathVariable("userId") int userId,@RequestBody User user) {
		return user;
		
	}
	
}
