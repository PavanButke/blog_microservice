package com.blog;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
@ComponentScan(basePackages ="com.blog" )
public class BlogPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogPracticeApplication.class, args);
	}

}
