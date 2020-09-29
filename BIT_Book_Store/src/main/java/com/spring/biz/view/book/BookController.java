package com.spring.biz.view.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.biz.book.BookService;
import com.spring.biz.book.BookVO;
import com.spring.biz.bookstock.BookStockService;
import com.spring.biz.bookstock.BookStockVO;
import com.spring.biz.cart.CartService;
import com.spring.biz.cart.CartVO;
import com.spring.biz.event.EventService;
import com.spring.biz.event.EventVO;
import com.spring.biz.jego.JegoService;
import com.spring.biz.jego.JegoVO;
import com.spring.biz.store.StoreService;
import com.spring.biz.store.StoreVO;

@Controller
@SessionAttributes("book")
public class BookController {
	@Autowired
	private BookService bookservice;
	@Autowired
	private BookStockService bookstockService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private JegoService jegoService;
	@Autowired
	private CartService cartService;
	@Autowired
	private EventService eventService;
	
	
	
	public BookController() {
		System.out.println("--->> BookController() 객체생성");
	}
	
	@RequestMapping(value="/goBookDetail.do", method=RequestMethod.GET)
	public String goBookDetail(int book_no,Model model) {
		System.out.println(">>상세페이지");
		System.out.println("book_no : " + book_no);
//		vo.setBook_no('3'); 임의로 설정한 책넘버니 나중에 지워줄것!
		BookVO bookVo = bookservice.getBook(book_no);
		List<BookStockVO> bookstockvo = bookstockService.getBookStockList(book_no);
//		StoreVO storevo = storeService.getStore(store_code);
		List<JegoVO> jego = jegoService.getjego(book_no);
		List<EventVO> eventlist = eventService.getEvents(book_no);
		
		System.out.println("bookVo111 : " + bookVo);
		System.out.println(">>상세페이지1");
		
		model.addAttribute("bookVo", bookVo);
		model.addAttribute("bookstockvo", bookstockvo);
		model.addAttribute("jego",jego);
		model.addAttribute("eventlist", eventlist);
		
		System.out.println("jego : " + jego);
		System.out.println(">>상세페이지2");
		System.out.println("bookVo : " + bookVo);
		System.out.println(">>상세페이지3");
		System.out.println("bookstockvo : " + bookstockvo);
		System.out.println("jego : " + jego);
		System.out.println("eventlist : " + eventlist);
		return "/seonghyeon/bookDetail.jsp";
	}

	
//	@RequestMapping(value="/jego.do",method=RequestMethod.GET)
//	public String jego(int book_no, Model model){
//		System.out.println("재고 구하기");
//		System.out.println("book_no : " + book_no);
//		BookVO bookvo = bookservice.getBook(book_no);
//		List<JegoVO> jego = jegoService.getjego(book_no);
//		System.out.println("jegoVO : " + jego);
//		model.addAttribute("jego", jego);
//		model.addAttribute("bookvo", bookvo);
//		return "/view/bookDetail.jsp";
//		
//		
//	}
	
	@RequestMapping(value="/jego.do2",method=RequestMethod.GET)
	public String jego(int book_no, String store_code, Model model){
		System.out.println("재고 구하기");
		System.out.println("book_no : " + book_no);
		System.out.println("store_code : " + store_code);
		
//		BookVO bookvo = bookservice.getBook(book_no);
		JegoVO jego2 = jegoService.getJego2(store_code);
		System.out.println("jego2 : " + jego2);
		model.addAttribute("jego2", jego2);
//		model.addAttribute("bookvo", bookvo);
		return "/view/ghmoonjego.jsp";
		
		
	}
	
	@RequestMapping(value="/cart.do", method=RequestMethod.POST)
	@ResponseBody
	public String
	modifyUpdate(String id, int book_no,  int cnt, 
	String store_code) throws Exception{
		
		ResponseEntity<String> entity = null;
		System.out.println("ReponseEntity() 실행");
		HashMap<String,Object> cartmap = new HashMap<>();
		System.out.println(id + "  " + book_no + "  " + cnt + "  " + store_code);
		cartmap.put("user_id", id);
		cartmap.put("book_no", book_no);
		cartmap.put("cnt", cnt);
		cartmap.put("store_code", store_code);
		System.out.println("cnt : " +cnt );
		
		String success="";
		try {
			int checkSame = cartService.checkSame(cartmap);
			System.out.println("checkSame : " + checkSame);
			if(checkSame==0) {//일치하는 값이 없으면 장바구니에 넣어준다
				int insertCart =cartService.insertCart(cartmap);
				System.out.println("성공");
				System.out.println("insertCart : " + insertCart);
				success = "success";
			}else {//일치하는 값이 있으면 alert창을 띄운다. (1이 아닌 다른 수를 넘김)
				int insertCart = 0;
				System.out.println("실패");
				System.out.println("insertCart : " + insertCart);
				success="fail";
			}
			System.out.println("success : " + success);
			 entity = new ResponseEntity<String>(success, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
	         entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);   
	      }
	      System.out.println("entity : " + entity);
	      return "{\"success\":\""+success+"\"}";

		}
		
		
	
	
	
//	public Map<String,Object> cart(  String id, int book_no,  int cnt, 
//			 String store_code, Model model) {
//		System.out.println("장바구니로 정보 전달하기");
//		
//		System.out.println("id : " + id);
//		HashMap<String,Object> cartmap = new HashMap<>();
//		cartmap.put("user_id", id);
//		cartmap.put("book_no", book_no);
//		cartmap.put("cnt", cnt);
//		cartmap.put("store_code", store_code);
//		
//		System.out.println("cnt : " +cnt );
//		//같은책을 장바구니에 넣었을때 이미 장바구니에 있는 경우
//		//장바구니에 있음을 알려주는 메시지를 띄운다.
//		
//		//DB연동해서 쿼리문을 통해 같은책이 있는지 확인 
//		//아이디와 북넘버,store_code를 넘김 (=cartmap안에 있으므로 cartmap넘김 )
//		int checkSame = cartService.checkSame(cartmap);
//		System.out.println("checkSame : " + checkSame);
//		String success;
//		if(checkSame==0) {//일치하는 값이 없으면 장바구니에 넣어준다
//			int insertCart =cartService.insertCart(cartmap);
//			System.out.println("성공");
//			System.out.println("insertCart : " + insertCart);
//			success = "성공!";
//		}else {//일치하는 값이 있으면 alert창을 띄운다. (1이 아닌 다른 수를 넘김)
//			int insertCart = 0;
//			System.out.println("실패");
//			System.out.println("insertCart : " + insertCart);
//			success="실패";
//		}
//		Map<String,Object> map = new HashMap<>();
//		map.put("success",success);
//		return map;
//		
//		
//	}

	
	
}
