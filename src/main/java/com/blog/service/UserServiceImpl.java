package com.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.blog.dao.UserRepository;
import com.blog.dto.UserDto;
import com.blog.entities.User;
import com.blog.exceptions.NoSuchElementExists;
import com.blog.exceptions.UserAlreadyExists;



@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto getUser(int userId) {
		User user= userRepository.findById(userId).orElse(null);
		if(user == null)
			throw new NoSuchElementExists("This user not available!");
		
		return modelMapper.map(user, UserDto.class) ;
	}

	@Override
	public List<UserDto> allUser(int pageNumber , int pageSize, boolean order, String... properties) {
		//List<User> userList = userRepository.findAll();
		List<UserDto> dtoUser = new ArrayList<UserDto>();
		Page<User> listOfUser = userRepository.findAll(PageRequest.of(pageNumber, pageSize , order?Direction.ASC:Direction.DESC , properties));
		List<User> content = listOfUser.getContent();
		for(User user : content ) {
			dtoUser.add(modelMapper.map(user , UserDto.class));
		}
		
		return dtoUser;
	}

	@Override
	public UserDto postUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		
		User getUser= userRepository.findById(user.getUserId()).orElse(null);
		if(getUser == null) {
			User insertedUser= userRepository.save(user);
		
			return modelMapper.map(insertedUser, UserDto.class);
		}
		else
			throw new UserAlreadyExists("This user entry exists already!");

		
		
	}
	@Override
	public UserDto updateUser(int userId, UserDto userDto) {
		User  myUser = userRepository.findById(userId).orElse(null);
		
		if(myUser==null)
			throw new NoSuchElementExists("User Is Not Available!");
		
		User user= modelMapper.map(userDto, User.class);

		userRepository.save(user);
		return userDto;
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



	


