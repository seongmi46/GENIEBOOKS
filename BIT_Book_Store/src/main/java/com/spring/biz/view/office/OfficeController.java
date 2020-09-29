package com.spring.biz.view.office;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.biz.office.BookOfficeService;
import com.spring.biz.office.BookVO;
import com.spring.biz.office.OfficeService;
import com.spring.biz.office.OfficeVO;



@Controller
@SessionAttributes("orderList")
public class OfficeController {
	@Autowired
	private OfficeService officeService;
	@Autowired
	private BookOfficeService bookOfficeService;
	
	
	public OfficeController() {
		System.out.println("---> OfficeController 실행");
	}
	
	@RequestMapping("/officeAdmin.do")
	public String officeAdmin(String office_no, Model model) {
		System.out.println(">> 관리페이지 이동");
		
		HashMap<String, Integer> sales = new HashMap<String, Integer>();
		office_no = "store2";
		int daySales = officeService.todaySalesValue(office_no);
		int monthSales = officeService.monthSalesValue(office_no);
		
		sales.put("day", daySales);
		sales.put("month", monthSales);
		
		model.addAttribute("SalesValue", sales);
		
		
		List<OfficeVO> monthTOTList = officeService.monthTOTCost(office_no);
		model.addAttribute("monthTOTList", monthTOTList);
				
		return "/seongmi/officeAdmin.jsp";
	}
	
	@RequestMapping("/officeOrder.do")
	public String officeOrder(String office_no, Model model) {
		System.out.println(">> 주문관리페이지 이동");
		
		
		String office_no_value = "store2";
		List<OfficeVO> orderList = officeService.getOrderList(office_no_value);
		System.out.println("orderList");
		model.addAttribute("orderList", orderList);
		
		return "/seongmi/officeOrder.jsp";
	}
	
	@RequestMapping("/bookModify.do")
	public String bookModify(String office_no, int book_no,  Model model) {
		System.out.println("도서수정페이지 실행");
		
		System.out.println(book_no);
		
		List<BookVO> categoryCode = bookOfficeService.getCategoryCode();
		System.out.println(categoryCode);
		model.addAttribute("categoryCode", categoryCode);
		
		
		BookVO bookInfo = bookOfficeService.getBookInfo(book_no);
		model.addAttribute("bookInfo", bookInfo);
		
		return "/seongmi/bookModify.jsp";
	}
	
	@RequestMapping("/modifyUpdate.do")
	@ResponseBody
	public ResponseEntity<Integer> modifyUpdate(int book_no, String book_name, String book_writer, String book_publisher,
							int book_price, int book_saleprice, String book_info, Date book_published_date,
							int book_total_page, Date book_entered_date, int ebook, int book_isbn, String book_img,
							String category_code, String category_main, String category_name) throws Exception {
		ResponseEntity<Integer> entity = null;
		
		System.out.println("도서업데이트 실행");
		BookVO vo = new BookVO();
		vo.setBook_no(book_no);
		vo.setBook_name(book_name);
		vo.setBook_writer(book_writer);
		vo.setBook_publisher(book_publisher);
		vo.setBook_price(book_price);
		vo.setBook_saleprice(book_saleprice);
		vo.setBook_info(book_info);
		vo.setBook_published_date(book_published_date);
		vo.setBook_total_page(book_total_page);
		vo.setBook_entered_date(book_entered_date);
		vo.setEbook(ebook);
		vo.setBook_isbn(book_isbn);
		vo.setBook_img(book_img);
		vo.setCategory_code(category_code);
		vo.setCategory_main(category_main);
		vo.setCategory_name(category_name);
		
		try {
			int category_no = bookOfficeService.getCategoryNo(vo);
			//System.out.println(category_no);
			vo.setCategory_no(category_no);
			//System.out.println(vo);
			
			int result = bookOfficeService.modifyUpdate(vo);
			entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);	
		}
		
		return entity;
	}
	
	@RequestMapping("/officeProduct.do")
	public String officeProduct(String office_no, Model model) {
		System.out.println(">> 전체상품관리 페이지 이동");
		
		List<OfficeVO> officeBookList = officeService.officeBookList(office_no); 
		model.addAttribute("officeBookList", officeBookList);
		
		return "/seongmi/officeProduct.jsp";
	}
	

	@RequestMapping("/officeNewBook.do")
	public String officeNewBook(Model model) {
		System.out.println(">> 상품입고페이지 이동");
		
		List<BookVO> categoryCode = bookOfficeService.getCategoryCode();
		System.out.println(categoryCode);
		model.addAttribute("categoryCode", categoryCode);
		
		return "/seongmi/officeNewBook.jsp";
	}
	
	@RequestMapping("/getCategoryMain.do")
	@ResponseBody
	public ResponseEntity<List<BookVO>> getCategoryMain(String category_code) throws Exception {
		System.out.println(">> getCategoryMain 실행");
		ResponseEntity<List<BookVO>> entity = null;
		System.out.println("category_code: " + category_code);
		try {
			List<BookVO> list = bookOfficeService.getCategoryMain(category_code);
			System.out.println(list);
			entity = new ResponseEntity<List<BookVO>>(list, HttpStatus.OK);
			
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<BookVO>>(HttpStatus.BAD_REQUEST);	
		}
		
		return entity;
	}
	
	//카테고리 이름 가져오기
	@RequestMapping("/getCategoryName.do")
	@ResponseBody
	public ResponseEntity<List<BookVO>> getCategoryName(String category_code, String category_main) throws Exception {
		System.out.println(">> getCategoryMain 실행");
		ResponseEntity<List<BookVO>> entity = null;
		System.out.println("category_code: " + category_code);
		System.out.println("category_main: " + category_main);
		
		HashMap<String, String> category = new HashMap<String, String>();
		category.put("category_code", category_code);
		category.put("category_main", category_main);
		
		try {
			List<BookVO> list = bookOfficeService.getCategoryName(category);
			System.out.println(list);
			entity = new ResponseEntity<List<BookVO>>(list, HttpStatus.OK);
			
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<BookVO>>(HttpStatus.BAD_REQUEST);	
		}
		
		return entity;
	}
	
	@RequestMapping("/searchBookName.do")
	@ResponseBody
	public ResponseEntity<List<BookVO>> getBookName(String book_name, String category_name) throws Exception {
		System.out.println(">> getBookName 실행");
		System.out.println(book_name + "    " + category_name);
		ResponseEntity<List<BookVO>> entity = null;
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("book_name", book_name);
		map.put("category_name", category_name);
		try {
			List<BookVO> list = bookOfficeService.searchBookName(map);
			System.out.println(list);
			entity = new ResponseEntity<List<BookVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<BookVO>>(HttpStatus.BAD_REQUEST);	
		}
		
		return entity;
	}
	
	
	
	
	@RequestMapping("/officeStock.do")
	public String officeStock(String office_no, Model model) {
		System.out.println(">> 재고관리 페이지 이동");
		
		List<OfficeVO> officeBookList = officeService.officeBookList(office_no); 
		model.addAttribute("officeBookList", officeBookList);
		
		return "/seongmi/officeStock.jsp";
	}
	
	
	@RequestMapping("/officeSales.do")
	public String officeSales() {
		System.out.println(">> 매출관리 페이지 이동");
		
		return "/seongmi/officeSales.jsp";
	}
	
	@RequestMapping("/officeMonthSales.do")
	public String officeMonthSales() {
		System.out.println(">> 월별매출관리 페이지 이동");
		
		return "/seongmi/officeMonthSales.jsp";
	}
	@RequestMapping("/officeDaySales.do")
	public String officeDaySales() {
		System.out.println(">> 일별매출관리 페이지 이동");
		
		return "/seongmi/officeDaySales.jsp";
	}
	@RequestMapping("/officeBookSales.do")
	public String officeBookSales() {
		System.out.println(">> 도서별매출관리 페이지 이동");
		
		return "/seongmi/officeBookSales.jsp";
	}
	
	@RequestMapping("/goBookDetail.do")
	public String goBookDetail(int book_no, Model model) {
		
		return "/seongmi/bookDetail.jsp";
	}
}
