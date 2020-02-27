package com.example.mybatis_h2_sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

//import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Results;
//import org.apache.ibatis.annotations.Select;

import com.example.mybatis_h2_sample.model.User;

@Mapper
public interface UserMapper {
	
	/*
	@Select("SELECT * FROM users WHERE first_name = #{firstName} and last_name = #{lastName}")
	@Results({
		@Result(property = "address",  column = "address")
	})
	*/
	List<User> getUsers(String firstName, String lastName);

}