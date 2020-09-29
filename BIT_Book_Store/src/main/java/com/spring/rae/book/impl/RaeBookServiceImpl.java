package com.spring.rae.book.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rae.book.RaeBookService;
import com.spring.rae.book.RaeBookVO;


// @Service : @Component 상속확장 어노테이션
//     비즈니스 로직처리 서비스 영역에 사용
@Service("raeBookService")
public class RaeBookServiceImpl implements RaeBookService {
	@Autowired //타입이 일치하는 객체(인스턴스) 주입
	//private BookDAO bookDAO;
	//private BookDAOSpring bookAO;
	private RaeBookDAOMybatis bookDAO;
	
	public RaeBookServiceImpl() {
		System.out.println(">> BookServiceImpl() 객체생성");
	}
	

	@Override
	public RaeBookVO getBook(RaeBookVO vo) {
		return bookDAO.getBook(vo);
	}

	@Override
	public List<RaeBookVO> getBookList() {
		return bookDAO.getBookList();
	}

	@Override
	public List<RaeBookVO> getBookList(RaeBookVO vo) {
		return bookDAO.getBookList(vo);
	}


	@Override
	public List<RaeBookVO> bestKorList(RaeBookVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


}
