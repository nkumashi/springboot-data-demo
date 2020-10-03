package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/api/user")
	@ResponseBody
	public UserDTO getUserByName(@RequestParam String name) {		
		User user = userService.getUserByName(name);
		return new UserDTO(user.getName(), user.getEmail());	
	}
}
