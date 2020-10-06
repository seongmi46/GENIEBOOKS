package com.spring.rae.book.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rae.book.BookVO;


@Repository("BookDAOMybatis")
public class BookDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public BookDAOMybatis() {
		System.out.println(">> BookDAOMybatis 객체생성");
	}

	// 글 하나 조회(상세조회)
	public BookVO getBook(BookVO vo) {
		System.out.println("===> MyBatis로 getBook() 실행");
		return mybatis.selectOne("RaeBookDAO.getBook", vo);
	}
	
	public List<BookVO> getBookList() {
		System.out.println("===> MyBatis로 getBookList() 실행");
		
		return null;
	}
	
	public List<BookVO> getBookList(BookVO vo) {
		System.out.println("===> MyBatis로 getBookList(vo) 실행");
		
		return mybatis.selectList("RaeBookDAO.getBookList", vo);
	}	
}








