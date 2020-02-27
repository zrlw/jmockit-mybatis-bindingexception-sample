package com.example.mybatis_h2_sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis_h2_sample.model.User;
import com.example.mybatis_h2_sample.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/getUsers")
	public List<User> getUsers(String firstName, String lastName) {
		List<User> users = userService.getUsersService(firstName, lastName);
		return users;
	}
	
}
