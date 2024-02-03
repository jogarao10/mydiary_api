package com.diary.api.service;

import java.util.List;

import com.diary.api.entities.User;

public interface UserService {
	
	public User saveUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);
	public User findById(Long id);
	public List<User> findAll();
	public User findByUserName(String username);
	

}
