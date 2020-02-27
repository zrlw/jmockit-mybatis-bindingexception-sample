package com.example.mybatis_h2_sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybatis_h2_sample.mapper.UserMapper;
import com.example.mybatis_h2_sample.model.User;

@Component
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<User> getUsersService(String firstName, String lastName) {
		return userMapper.getUsers(firstName, lastName);
	}
}
