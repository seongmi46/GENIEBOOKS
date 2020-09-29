package com.spring.rae.view.board;

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

import com.spring.rae.book.BookService;
import com.spring.rae.book.BookVO;
import com.spring.rae.book.impl.BookServiceImpl;


@Controller
@SessionAttributes("book") //book 라는 이름의 Model이 있으면 session에 저장
public class BookController {
	@Autowired
	private BookService bookService;
	
	public BookController() {
		System.out.println("--->> BookController() 객체생성");
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
	@RequestMapping("/getBook.do")
	public String getBoard(BookVO vo, Model model) {
		System.out.println(">>> 글 상세 - String getBoard()");
		
		BookVO book = bookService.getBook(vo);
		model.addAttribute("book", book);
		System.out.println("getBook() book : " + book);
		
		return "getBook.jsp";
	}
	
	@RequestMapping("/getBookList.do")
	public String getBookList(BookVO vo, Model model) {
		System.out.println(">>> 게시글 전체 목록 - String getBookList()");
		
		//검색조건 값 null체크 후 기본값 설정
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		//List<BookVO> bookList = bookDAO.getBookList();
		List<BookVO> bookList = bookService.getBookList(vo);
		model.addAttribute("bookList", bookList);
		
		return "getBookList.jsp";
	}
	
	@RequestMapping("/insertBook.do")
	public String insertBook(BookVO vo) throws IllegalStateException, IOException {
		System.out.println(">>> 글 입력 - insertBook()");
		System.out.println("> insertBook() vo : " + vo);
		
		/* 파일업로드 관련 처리
		 * MultipartFile 인터페이스 주요 메소드
		 * String getOriginalFilename() : 업로드한 파일명 찾기
		 * void transferTo(File dest) : 업로드할 파일을 업로드 처리
		 * boolean isEmpty() : 업로드 할 파일의 존재여부(없으면 true 리턴)
		 */
		MultipartFile uploadFile = vo.getUploadFile();
		System.out.println("> uploadFile : " + uploadFile);
		if (!uploadFile.isEmpty()) { //파일이 있으면(비어있지 않으면)
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("c:/MyStudy/temp/" + fileName));
		}
		
		bookService.insertBook(vo);
		return "getBookList.do";
	}
	
	//@ModelAttribute("book") : Model에 book라는 속성명의 객체가 있으면 사용
	//     없으면 book라는 이름으로 새로 생성
	@RequestMapping("/updateBook.do")
	public String updateBook(@ModelAttribute("book") BookVO vo) {
		System.out.println(">>> 글 수정 - updateBook()");
		System.out.println("updateBook() vo : " + vo);
		
		bookService.updateBook(vo);
		return "getBookList.do";
	}
	
	@RequestMapping("/deleteBook.do")
	public String deleteBook(BookVO vo) {
		System.out.println(">>> 글 삭제 - deleteBook()");
		
		bookService.deleteBook(vo);
		return "getBookList.do";
	}
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody //response 객체의 몸체(body)에 데이타 전달
	public List<BookVO> dataTransform(BookVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BookVO> boardList = bookService.getBookList(vo);
		System.out.println("bookList : " + bookList);
		
		return bookList;
	}
	

}








