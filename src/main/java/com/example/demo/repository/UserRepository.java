package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserRepository {
	private List<User> users = new ArrayList<User>();
	
	public UserRepository() {
		this.users.add(new User("Naveen", "naveenkumashi@gmail.com"));
	}
	
	public User createUser(String name, String email) {
		User user = new User(name, email);
		this.users.add(user);
		return user;
	}
	
	public User getUserByName(String name) {
		return this.users.stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null);	
	}
	
	public User getUserByEmail(String email) {
		return this.users.stream().filter(u -> u.getName().equals(email)).findAny().orElse(null);	
	}
	
	public User updateUserEmail(String name, String email) {
		User user = this.users.stream().filter(u -> u.getName().equals(name)).findAny().orElse(null);
		if(user != null) {
			user.setEmail(email);
			return user;
		}
		return null;
	}
	
	public boolean deleteUserByName(String name) {
		User user = this.users.stream().filter(u -> u.getName().equals(name)).findAny().orElse(null);
		if(user != null) {
			this.users.remove(user);
			return true;
		}
		return false;
	}
}
