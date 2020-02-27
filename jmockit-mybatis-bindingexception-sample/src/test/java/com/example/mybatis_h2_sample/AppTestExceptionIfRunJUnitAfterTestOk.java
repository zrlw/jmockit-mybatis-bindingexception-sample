package com.example.mybatis_h2_sample;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybatis_h2_sample.model.User;
import com.example.mybatis_h2_sample.service.UserService;

import junit.framework.TestCase;

/**
 * AppTestE
 * if test it alone, then test ok,
 * but if test it after AppTest0, then throw org.apache.ibatis.binding.BindingException:
 *     Parameter 'firstName' not found. Available parameters are [arg1, arg0, param1, param2]
 *
 */
@SpringBootTest(classes = App.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTestExceptionIfRunJUnitAfterTestOk {
	@Autowired
	private UserService userService;

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
		List<User> users = userService.getUsersService("Mick", "Jackson");
		TestCase.assertEquals(1, users.size());
		TestCase.assertEquals("Mick", users.get(0).getFirstName());
	}

}
