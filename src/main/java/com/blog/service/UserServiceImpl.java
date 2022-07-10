package com.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.blog.dao.UserRepository;
import com.blog.dto.UserDto;
import com.blog.entities.User;



@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto getUser(int userId) {
		User user= userRepository.findById(userId).get();

		return modelMapper.map(user, UserDto.class) ;
	}

	@Override
	public List<UserDto> allUser() {
		List<User> userList = userRepository.findAll();
		List<UserDto> dtoUser = new ArrayList<UserDto>();
		for(User user : userList ) {
			dtoUser.add(modelMapper.map(user , UserDto.class));
		}
		
		return dtoUser;
	}

	@Override
	public UserDto postUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		
		User newUser = userRepository.save(user);
		
		return modelMapper.map(newUser, UserDto.class);
	}
	@Override
	public UserDto updateUser(int userId, UserDto userDto) {
			User user = modelMapper.map(userDto, User.class);
			
			User newUser = userRepository.save(user);
			
			return modelMapper.map(newUser, UserDto.class);
	}

	@Override
	public void deleteUser(int userId) {
		
		userRepository.deleteById(userId);
	}

	@Override
	public List<UserDto> getByUserEmail(String userEmail) {
		List<User> users= userRepository.mails(userEmail);
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		for(User user: users) {
			userDtos.add(modelMapper.map(user, UserDto.class));
		}
		return userDtos;
	}
}



	


