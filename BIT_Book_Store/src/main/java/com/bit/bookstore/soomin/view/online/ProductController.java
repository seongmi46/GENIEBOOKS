package com.bit.bookstore.soomin.view.online;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.bookstore.Paging;
import com.bit.bookstore.soomin.online.OnlineStoreService;
import com.bit.bookstore.vo.BookNCategoryVO;
import com.bit.bookstore.vo.BookStockVO;
import com.bit.bookstore.vo.BookVODateToString;
import com.bit.bookstore.vo.GoodsVODateToString;
import com.spring.biz.office.BookOfficeService;
import com.spring.biz.office.BookVO;

@Controller
@RequestMapping("/soomin/online")
public class ProductController {

	@Autowired
	private OnlineStoreService onlineStoreService;
	
	@Autowired
	private BookOfficeService bookOfficeService;
	
	@RequestMapping(value = "/insertBook.do")
	public ModelAndView insertBook(
			@RequestParam(required = false) String category_code,
			@RequestParam(required = false) String category_main,
			@RequestParam(required = false) String category_name,
			@ModelAttribute BookVODateToString bookvo,
			ModelAndView mav,
			BindingResult errors, HttpServletResponse response) throws IOException {
		
		System.out.println("insertBook.do URL");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String alert = null;
		
		//modelAttribute 받아올 때 오류생기면 아래로
		if ( errors.hasErrors() ){
			System.out.println( errors.getAllErrors().toString() );
			alert = "입력한 타입이 일치하지 않습니다.다시 시도해주세요.";
		}else {
		
			//category_code, main, name이 일치하는 category_no을 가져온다.
			//없으면 0 리턴
			int category_no = onlineStoreService.getCategory_no(category_code, category_main,category_name);
			
			//카테고리 선택이 이상할 시
			if(category_no == 0) {
				alert = "카테고리가 제대로 선택되지 않았습니다.다시 입력해주세요.";
				out.flush();return null;
			}else {
			
				//카테고리 선택이 제대로 되어있을 시
				bookvo.setCategory_no(category_no);
				
				//동일한 책이 있는지 검사
				int count = onlineStoreService.checkBook(bookvo);
				if(count != 0) {
					alert = "동일한 책이 이미 있습니다.";
				}else {
				
				
					int insertSuccess = onlineStoreService.insertBook(bookvo);
					
					//데이터가 제대로 insert되지 않았을시
					if(insertSuccess != 1) {
						alert = "데이터가 입력되지 않고 에러가 발생했습니다.다시 시작해주세요.";
					}else {
					
						alert = "책이 성공적으로 입고되었습니다.";
					}
				}
			}
		}
		
		mav.addObject("alert", alert);
		mav.addObject("path", "addBookORGoods.do");
		mav.setViewName("../alert.jsp");
		
		return mav;
	}
	
	
	//굿즈입고
	@RequestMapping(value = "/insertGoods.do")
	public ModelAndView insertGoods(
			@RequestParam(required = false) String category_code,
			@RequestParam(required = false) String category_main,
			@RequestParam(required = false) String category_name,
			@ModelAttribute GoodsVODateToString goodsvo,
			MultipartFile uploadFile,//이미지 파일 저장
			ModelAndView mav,
			BindingResult errors, HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		
		System.out.println("insertGoods.do URL");
		
		String alert = null;
		
		//modelAttribute 받아올 때 오류생기면 아래로
		if ( errors.hasErrors() ){
			System.out.println( errors.getAllErrors().toString() );
			alert = "입력한 타입이 일치하지 않습니다.다시 시도해주세요.";
		}else {
			//동일한 굿즈가 존재하는지 검사
			int count = onlineStoreService.checkGoods(goodsvo.getGoods_name());
			
			//동일한 굿즈가 존재하면
			if(count != 0) {
				alert = "동일한 이름의 굿즈가 이미 있습니다.";
			}else {
				//이미지 업로드
				if(uploadFile != null) {//이미지 파일이 비어있지 않으면
					String fileName = uploadFile.getOriginalFilename();//기존 파일명
					String path = request.getServletContext().getRealPath("resources/images/goods_img");
					fileName = fileUploadMethod(fileName, uploadFile.getBytes(), path, uploadFile);//저장된 파일명
					goodsvo.setGoods_image(fileName);
					
					
					//동일한 굿즈가 없을 시 입고
					int insertSuccess = onlineStoreService.insertGoods(goodsvo);
					
					//데이터가 제대로 insert되지 않았을 시
					if(insertSuccess != 1) {
						alert = "데이터가 입력되지 않고 에러가 발생했습니다.다시 시작해주세요.";
					}else {
					
						alert = "사은품이 성공적으로 입고되었습니다.";
					}
					
					
				}else {//이미지 파일이 없으면
					alert = "파일 업로드가 되지 않았습니다.다시 시작해주세요.";
				}
				
				
			}
		}
		
		mav.addObject("alert", alert);
		mav.addObject("path", "addBookORGoods.do");
		mav.setViewName("../alert.jsp");
		System.out.println(alert);
		return mav;
	}
	
	
	//중복방지 파일 업로드 메소드
	public String fileUploadMethod(String fileName, byte[] fileData, String path, MultipartFile mf) {
		UUID uuid = UUID.randomUUID();
		String saveName = uuid.toString() + "_" + fileName;
		File saveFile = new File(path, saveName);
		
		try {
			mf.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return saveName;
		
	}
	
	//상품재고 및 조회
	@RequestMapping("/productStock.do")
	public ModelAndView productStock(
			ModelAndView mav,
			@RequestParam(required = false, defaultValue = "1") int cPage,//현재 페이지
			@RequestParam(required = false) String search) {
		
		//페이징 처리를 위한 paging 객체생성해서 값 읽고 설정
		Paging p = new Paging();
		
		//1.전체 게시물의 수 구하기(온라인상점의 모든 데이터)
		int totalRecord = onlineStoreService.getOnlineTotalCount("online", search);//DB에 저장된 전체 데이터 수를 가져옴
		p.setTotalRecord(totalRecord);//전체 게시글 수 저장
		p.setTotalPage();//하나당 페이지에 표시할 게시글 수를 계산해서 총 몇 페이지인지 계산하는 메소드 실행
		
		//2.현재 페이지 구하기
		p.setNowPage(cPage);
		
		//3.현재 페이지에 표시할 게시글 시작번호(begin), 끝번호(end) 구하기
		p.setEnd(p.getNowPage() * p.getNumPerPage());//나타낼 게시물의 끝 번호
		p.setBegin(p.getEnd() - p.getNumPerPage() + 1);//나타낼 게시글의 시작 번호
		
		//3-1. 글 끝번호가 데이터 건 수보다 많아지면 데이터 건 수와 동일한 번호로 설정
		if(p.getEnd() > p.getTotalRecord()) {
			p.setEnd(p.getTotalRecord());
		}
		
		//블록 = ex. 한페이지에 1, 2, 3 -> 1번째블록, 4, 5, 6 -> 2번째블록
		//4.블록의 시작페이지, 끝페이지 구하기(페이지 아래에서 블록 선택하기 위함)
		int nowBlock = (p.getNowPage() - 1) / p.getPagePerBlock() + 1;//현재블록 = (현재 페이지 - 1) / 페이지당 블록 수 + 1
		int endPage = nowBlock * p.getPagePerBlock();
		int beginPage = endPage - p.getPagePerBlock() + 1;
		p.setEndPage(endPage);
		p.setBeginPage(beginPage);
		
		//4-1.끝페이지(endpage)가 전체 페이지 수(totalPage)보다 크면
		//끝페이지를 전체 페이지수로 변경처리
		if(p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}
		
		
		//시작 게시글 번호, 끝 게시글 번호로 데이터 불러오기
		List<BookStockVO> bookStockvoList = onlineStoreService.getBookStockList(p.getBegin(), p.getEnd(), search);
		
		System.out.println(p.toString());
		
		//리스트와 p객체 저장해서 전달
		mav.addObject("bookStockvoList", bookStockvoList);
		mav.addObject("pvo", p);
		mav.setViewName("productList.jsp");
		
		return mav;
	}
	
	//재고 숫자 변경
	@ResponseBody
	@RequestMapping(value = "/stockChange.do", method = RequestMethod.POST)
	public String stockChange(int stock_idx, int cnt) {
		
		System.out.println("stockChange.do 연결 메소드");
		int countSuccess = onlineStoreService.updateStockCnt(stock_idx, cnt);
		
		String result = "";
		
		if(countSuccess == 1) {
			result = "success";
		}else {
			result = "fail";
		}
		
		
		return result;
	}
	
	
	//책 상세 정보 불려오기
	@ResponseBody
	@RequestMapping(value = "/bookDetail.do", method = RequestMethod.GET)
	public BookNCategoryVO bookDetail(int book_no) {
		System.out.println("bookDetail.do 연결 메소드");
		
		BookNCategoryVO bcvo = onlineStoreService.getBookDetail(book_no);
		return bcvo;
	}
	
	//책 정보 수정하는 창
	@RequestMapping(value = "/bookModify.do", method = RequestMethod.GET)
	public String bookModify(@RequestParam int book_no, Model model, HttpSession session) {
		System.out.println("bookModify.do 연결 메소드");
		
		//세션에 관리자 로그인이 되어있는지 확인
		if(session.getAttribute("admin") == null) {
			new OnlineStoreController().notAdminLogin(model);
			return "../alert.jsp";
		}
		
		//카테고리 저장
		List<BookVO> categoryCode = bookOfficeService.getCategoryCode();
		model.addAttribute("categoryCode", categoryCode);
		
		BookVO bcvo = bookOfficeService.getBookInfo(book_no);
		model.addAttribute("bcvo", bcvo);
		
		
		return "bookModify.jsp";
	}
	
	//책 정보 수정
	@RequestMapping(value = "/bookupdate.do", method = RequestMethod.POST)
	public String bookupdate(
			@ModelAttribute BookVODateToString bvo,
			@RequestParam String category_code,
			@RequestParam String category_main,
			@RequestParam String category_name,
			Model model, HttpSession session) {
		
		System.out.println("bookupdate.do 연결 메소드");
		
		String alert = null;
		String path = null;
		
		//세션에 관리자 로그인이 되어있는지 확인
		if(session.getAttribute("admin") == null) {
			new OnlineStoreController().notAdminLogin(model);
			return "../alert.jsp";
		}
		
		System.out.println("bvo : " + bvo);
		
		//카테고리 번호 가져오기
		int category_no = onlineStoreService.getCategory_no(
				category_code, category_main, category_name);
		System.out.println("category_no" + category_no);
		bvo.setCategory_no(category_no);
		
		int result = onlineStoreService.updateBook(bvo);
		
		if(result != 1) {
			alert = "데이터가 수정되지 않았습니다. 다시 시도하세요.";
			path = "bookModify.do?book_no=" + bvo.getBook_no();
		}else {
			alert = "책 정보가 수정되었습니다.";
			path = "productStock.do";
		}
		
		model.addAttribute("alert", alert);
		model.addAttribute("path", path);
		
		return "../alert.jsp";
	}
	
	
	
	
	
}
