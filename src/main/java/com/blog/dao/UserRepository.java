package com.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.blog.dto.UserDto;
import com.blog.entities.User;




public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value= "from User u where u.userEmail=:email " )
	List<User> mails(@Param("email") String userEmail);

}
