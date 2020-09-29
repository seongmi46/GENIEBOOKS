package com.spring.biz.office.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.office.BookOfficeService;
import com.spring.biz.office.BookVO;

@Service("bookOfficeService")
public class BookServiceImpl implements BookOfficeService{
	@Autowired //타입이 일치하는 객체(인스턴스) 주입
	private BookofficeDAOMybatis bookDAO;
	
	
	@Override
	public BookVO getBookInfo(int book_no) {
		return bookDAO.getBookInfo(book_no);
	}


	@Override
	public List<BookVO> getCategoryCode() {
		return bookDAO.getCategoryCode();
	}


	@Override
	public List<BookVO> getCategoryMain(String category_code) {
		return bookDAO.getCategoryMain(category_code);
	}


	@Override
	public List<BookVO> getCategoryName(Map<String, String> category) {
		return bookDAO.getCategoryName(category);
	}


	@Override
	public List<BookVO> searchBookName(Map<String, String> map) {
		return bookDAO.searchBookName(map);
	}


	@Override
	public int getCategoryNo(BookVO vo) {
		return bookDAO.getCategoryNo(vo);
	}


	@Override
	public int modifyUpdate(BookVO vo) {
		return bookDAO.modifyUpdate(vo);
	}

}
