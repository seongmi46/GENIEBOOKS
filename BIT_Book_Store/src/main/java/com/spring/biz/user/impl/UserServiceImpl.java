package com.spring.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	//private UserDAO userDAO;
	private UserDAOMybatis userDAO;
	
	public UserServiceImpl() {
		System.out.println(">> UserServiceImpl() 실행(객체생성)");
	}

	@Override
	public int ID_Check(String id) {
		return userDAO.GetCheckId(id);
	}

}
