package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.UserDao;
import com.tka.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public boolean userCheck(User user) {
		System.err.println("in service"+user);
		return userDao.userCheck(user);
		
	}
	
	

}
