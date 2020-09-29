package com.spring.biz.office;

import java.util.List;
import java.util.Map;

public interface OfficeBookService {
	/*
	 * 
	 * //주문리스트
	List<OfficeVO> getOrderList(String office_no);
	 */
	
	OfficeBookVO getBookInfo(int book_no);	
	List<OfficeBookVO> getCategoryCode();
	List<OfficeBookVO> getCategoryMain(String category_code);
	List<OfficeBookVO> getCategoryName(Map<String, String> category);
	List<OfficeBookVO> searchBookName(Map<String, String> map);
	int getCategoryNo(OfficeBookVO vo);
	int modifyUpdate(OfficeBookVO vo);
}
