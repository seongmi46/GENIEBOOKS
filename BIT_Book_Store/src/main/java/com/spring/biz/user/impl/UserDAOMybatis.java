package com.spring.biz.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("UserDAOMybatis")
public class UserDAOMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	int GetCheckId(String id) {
		return mybatis.selectOne("userDAO.checkId", id);
	}
}
