package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.blog.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
