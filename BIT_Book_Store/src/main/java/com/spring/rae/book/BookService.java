package com.spring.rae.book;

import java.util.List;

public interface BookService {
	// CRUD 기능 구현 메소드 정의
	BookVO getBook(BookVO vo);
	List<BookVO> getBookList();
	List<BookVO> getBookList(BookVO vo);
	List<BookVO> bestKorList(BookVO vo);  // 베스트셀러-국내
	
	
}
