package com.spring.biz.office.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.office.BookVO;

@Repository("BookDAOMybatis")
public class BookDAOMybatis {

	@Autowired
	public SqlSessionTemplate mybatis;
	
	public BookDAOMybatis() {
		System.out.println(">> BookDAOMybatis 객체 생성");
	}
	
	//책정보 가져오기
	public BookVO getBookInfo(int book_no) {
		System.out.println("---> mybatis로 getBookInfo 실행");
		return mybatis.selectOne("officeBookDAO.getBookInfo", book_no);
	}
	
	//카테고리 대분류 가져오기
	public List<BookVO> getCategoryCode() {
		
		return mybatis.selectList("officeBookDAO.getCategoryCode");
	}
	
	//카테고리 중분류 가져오기
	public List<BookVO> getCategoryMain(String category_code){
		System.out.println("---> Mybatis로 중분류 가져오기");
		return mybatis.selectList("officeBookDAO.getCategoryMain",category_code);
	}
	
	//카테고리 이름 가져오기
	public List<BookVO> getCategoryName(Map<String, String> category){
		System.out.println("---> Mybatis로 이름 가져오기");
		
		return mybatis.selectList("officeBookDAO.getCategoryName", category);
	}
	
	//책 이름 가져오기
	public List<BookVO> searchBookName(Map<String, String> map){
		
		return mybatis.selectList("officeBookDAO.searchBookName", map);
	}
	
	//카테고리 넘버 가져오기
	public int getCategoryNo(BookVO vo) {
		return mybatis.selectOne("officeBookDAO.getCategoryNo", vo);
	}
	
	//책 정보 수정
	public int modifyUpdate(BookVO vo) {
		return mybatis.update("officeBookDAO.modifyUpdate", vo);
	}
}
