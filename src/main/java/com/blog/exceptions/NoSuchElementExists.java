package com.blog.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class NoSuchElementExists extends RuntimeException {
	
	private String message;
}
	
	


