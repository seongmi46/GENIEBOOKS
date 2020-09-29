package com.spring.rae.book.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rae.book.BookService;
import com.spring.rae.book.BookVO;


// @Service : @Component 상속확장 어노테이션
//     비즈니스 로직처리 서비스 영역에 사용
@Service("bookService")
public class BookServiceImpl implements BookService {
	@Autowired //타입이 일치하는 객체(인스턴스) 주입
	//private BookDAO bookDAO;
	//private BookDAOSpring bookAO;
	private BookDAOMybatis bookDAO;
	
	public BookServiceImpl() {
		System.out.println(">> BookServiceImpl() 객체생성");
	}
	

	@Override
	public BookVO getBook(BookVO vo) {
		return bookDAO.getBook(vo);
	}

	@Override
	public List<BookVO> getBookList() {
		return bookDAO.getBookList();
	}

	@Override
	public List<BookVO> getBookList(BookVO vo) {
		return bookDAO.getBookList(vo);
	}


	@Override
	public List<BookVO> bestKorList(BookVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


}
