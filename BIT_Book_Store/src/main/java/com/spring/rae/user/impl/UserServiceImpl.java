package com.spring.rae.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rae.user.UserService;
import com.spring.rae.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	//private UserDAO userDAO;
	private UserDAOSpring userDAO;
	
	public UserServiceImpl() {
		System.out.println(">> UserServiceImpl() 실행(객체생성)");
	}
	
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

}
