package com.spring.rae.view.book;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.rae.book.RaeBookService;
import com.spring.rae.book.RaeBookVO;
import com.spring.rae.book.impl.RaeBookServiceImpl;


@Controller
@SessionAttributes("book") //book 라는 이름의 Model이 있으면 session에 저장
public class RaeBookController {
	@Autowired
	private RaeBookService bookService;
	
	public RaeBookController() {
		System.out.println("--->> RaeBookController() 객체생성");
	}
	
	// 메소드에 선언된 @ModelAttribute 는 리턴된 데이터를 View에 전달
	// @ModelAttribute 선언된 메소드는 @RequestMapping 메소드보다 먼저 실행됨
	// 뷰에 전달될 때 설정된 명칭(예: conditionMap)으로 전달
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		System.out.println(">>> @ModelAttribute - Map searchConditionMap()");
		// key: 제목, value: TITLE
		// key: 내용, value: CONTENT
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	//리턴타입 ModelAndView -> String 변경
	//전달할 데이터 저장 타입 : ModelAndView -> Model
	@RequestMapping("/bestKorList.do")
	public String bestKorList(RaeBookVO vo, Model model) {
		System.out.println(">>> 게시글 전체 목록 - String bestKorList()");
		
		//List<BookVO> bookList = bookDAO.getBookList();
		List<RaeBookVO> bestKorList = bookService.bestKorList(vo);
		model.addAttribute("bestKorList", bestKorList);
		
		return "bestMonth.jsp";
	}
	
	
	@RequestMapping("/getBook.do")
	public String getBoard(RaeBookVO vo, Model model) {
		System.out.println(">>> 글 상세 - String getBoard()");
		
		RaeBookVO book = bookService.getBook(vo);
		model.addAttribute("book", book);
		System.out.println("getBook() book : " + book);
		
		return "getBook.jsp";
	}
	
	@RequestMapping("/getBookList.do")
	public String getBookList(RaeBookVO vo, Model model) {
		System.out.println(">>> 책 전체 목록 - String getBookList()");
		
		//List<BookVO> bookList = bookDAO.getBookList();
		List<RaeBookVO> bookList = bookService.getBookList(vo);
		model.addAttribute("bookList", bookList);
		
		return "bestMonth.jsp";
	}
	


}








