package com.diary.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diary.api.entities.User;
import com.diary.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User insertUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		return user1;
	}
	
	@GetMapping("/")
	public List<User> getAllUsers() {
		List<User> users = userService.findAll();
		return users;
	}

}
