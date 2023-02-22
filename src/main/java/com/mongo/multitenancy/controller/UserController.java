package com.mongo.multitenancy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.multitenancy.model.User;
import com.mongo.multitenancy.service.UserService;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public void save(@RequestBody User user) {
		userService.saveUser(user);
	}

	@GetMapping
	public List<User> getAll() {
		return userService.getAllUsers();
	}
}
