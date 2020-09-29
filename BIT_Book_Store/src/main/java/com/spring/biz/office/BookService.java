package com.spring.biz.office;

import java.util.List;
import java.util.Map;

public interface BookService {
	/*
	 * 
	 * //주문리스트
	List<OfficeVO> getOrderList(String office_no);
	 */
	
	BookVO getBookInfo(int book_no);	
	List<BookVO> getCategoryCode();
	List<BookVO> getCategoryMain(String category_code);
	List<BookVO> getCategoryName(Map<String, String> category);
	List<BookVO> searchBookName(Map<String, String> map);
	int getCategoryNo(BookVO vo);
	int modifyUpdate(BookVO vo);
}
