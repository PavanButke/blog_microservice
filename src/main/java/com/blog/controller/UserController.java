package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.UserDto;
import com.blog.entities.User;
import com.blog.service.UserService;

@RestController
@RequestMapping("user-api")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value="/users/{userId}" , produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDto> getUser(@PathVariable("userId") int userId) {
		return new ResponseEntity<UserDto>(userService.getUser(userId), HttpStatus.OK); 
	}
	
	@GetMapping(value="/users", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<UserDto> allUser() {
	return userService.allUser();
		
	}
	
	
	@PostMapping(value="/users" ,  produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDto > postUser(@RequestBody UserDto user) {
		 
		return new ResponseEntity<UserDto>(userService.postUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping(value="/users/userId",  produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String>  updateUser(@PathVariable("userId") int userId,@RequestBody UserDto user) {
		 userService.updateUser(userId, user);
		return new  ResponseEntity<String>("Hey , you just updated an user!",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/users/userId",  produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId) {
		 userService.deleteUser(userId);
		 return new  ResponseEntity<String>("Hey , you just deleted an user!",HttpStatus.OK);
	}
	
	@GetMapping("/users/mail/{userEmail}")
	public ResponseEntity<List<UserDto>> getByUserEmail(@PathVariable("userEmail") String userEmail) {
		return new ResponseEntity<List<UserDto>>(userService.getByUserEmail(userEmail) , HttpStatus.OK);	

	}
	
}
