package com.spring.biz.jego;

import java.util.List;

import com.spring.biz.bookstock.BookStockVO;

public interface JegoService {
//	void insertjego(JegoVO vo);
//	void updatejego(JegoVO vo);
//	void deletejego(JegoVO vo);
	List<JegoVO> getjego(int book_no);
	JegoVO getJego(String store_code);
	JegoVO getJego2(String store_code);
}

