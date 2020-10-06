package com.spring.biz.office.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.office.OfficeBookService;
import com.spring.biz.office.OfficeBookVO;

@Service("officeBookService")
public class OfficeBookServiceImpl implements OfficeBookService{
	@Autowired //타입이 일치하는 객체(인스턴스) 주입
	private OfficeBookDAOMybatis bookDAO;
	
	
	@Override
	public OfficeBookVO getBookInfo(int book_no) {
		return bookDAO.getBookInfo(book_no);
	}


	@Override
	public List<OfficeBookVO> getCategoryCode() {
		return bookDAO.getCategoryCode();
	}


	@Override
	public List<OfficeBookVO> getCategoryMain(String category_code) {
		return bookDAO.getCategoryMain(category_code);
	}


	@Override
	public List<OfficeBookVO> getCategoryName(Map<String, String> category) {
		return bookDAO.getCategoryName(category);
	}


	@Override
	public List<OfficeBookVO> searchBookName(Map<String, String> map) {
		return bookDAO.searchBookName(map);
	}


	@Override
	public int getCategoryNo(OfficeBookVO vo) {
		return bookDAO.getCategoryNo(vo);
	}


	@Override
	public int modifyUpdate(OfficeBookVO vo) {
		return bookDAO.modifyUpdate(vo);
	}

}
