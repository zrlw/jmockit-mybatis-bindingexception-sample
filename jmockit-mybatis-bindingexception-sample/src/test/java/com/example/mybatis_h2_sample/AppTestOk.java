package com.example.mybatis_h2_sample;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybatis_h2_sample.mapper.UserMapper;
import com.example.mybatis_h2_sample.model.User;
import com.example.mybatis_h2_sample.service.UserService;

import junit.framework.TestCase;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

/**
 * Run Junit Test should add jmockit javaagent like this (version 1.49 as example):
 *     -javaagent:<replace maven local repository directory here>/org/jmockit/jmockit/1.49/jmockit-1.49.jar
 * at:
 *     run as - Run Configurations - JUnit - new launch configuration - arguments - VM arguments 
 *
 */
@SpringBootTest(classes = App.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTestOk {
	@Tested
	private UserService userService;
	
	@Injectable
	private UserMapper userMapper;

	private List<User> mockUsers;
	
	@Before
	public void before() {
		mockUsers = new ArrayList<>();
		mockUsers.add(new User("MockFirstName", "MockLastName"));
	}
	
	@Test
	@Transactional
	@Rollback(value = true)
	public void testGetUsers() throws Exception {
		new Expectations() {
			{
				userMapper.getUsers((String) any, (String) any);
				result = mockUsers;
			}
		};
		List<User> users = userService.getUsersService("", "");
		TestCase.assertEquals(1, users.size());
		TestCase.assertEquals("MockFirstName", users.get(0).getFirstName());
	}

}
