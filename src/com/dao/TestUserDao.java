package com.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.model.User;

public class TestUserDao {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddUser() {
		UserDao userDao=new UserDao();
		try{
		userDao.addUser("test","test","test","test","test","test");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
