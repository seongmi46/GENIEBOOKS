package com.spring.rae.book;

import java.util.List;

public interface RaeBookService {
	// CRUD 기능 구현 메소드 정의
	RaeBookVO getBook(RaeBookVO vo);
	List<RaeBookVO> getBookList();
	List<RaeBookVO> getBookList(RaeBookVO vo);
	List<RaeBookVO> bestKorList(RaeBookVO vo);  // 베스트셀러-국내
	
	
}
