package com.example.demo.model;

//import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@Entity
public class User {
	private String name;
	private String email;
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
