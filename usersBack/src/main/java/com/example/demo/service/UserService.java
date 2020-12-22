package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

	public List<User> userList();
	
	public User ajout(User user);
	
	public User edit(User user);
	
	public void delete(Integer id);
	
	public User getUserByUsername(String username);
	
	public User getUserById(Integer Id);

	
}
