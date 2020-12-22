package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	public List<User> ListUser() {
		return userService.userList();
	}
	
	@PostMapping("/addUser")
	public User create(@RequestBody User user) {
		return userService.ajout(user);
	}
	
	@PutMapping("/updateUser")
	public User update(@RequestBody User user) {
		return userService.edit(user);
	}
	
	@DeleteMapping("delete/{userId}")
	public void deleteUser(@PathVariable Integer userId) {
		userService.delete(userId);
	}
	
}
