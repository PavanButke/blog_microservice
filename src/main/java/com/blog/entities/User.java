package com.blog.entities;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "user")
public class User {

private int userId;
private String userName;
private String userEmail;
private String about;


	
}
