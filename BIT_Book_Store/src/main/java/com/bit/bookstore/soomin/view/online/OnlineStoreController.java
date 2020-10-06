package com.bit.bookstore.soomin.view.online;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.bookstore.soomin.online.OnlineStoreService;
import com.bit.bookstore.vo.StoreVO;
import com.spring.biz.office.BookOfficeService;
import com.spring.biz.office.BookVO;

@Controller
@RequestMapping("/soomin/online")
public class OnlineStoreController {
	
	//온라인 관리자이므로 항상 store_code는 online
	String store_code = "online";
	
	
	
	
	@Autowired
	private OnlineStoreService onlineStoreService;
	
	@Autowired
	private BookOfficeService bookOfficeService;
	
	
	//세션이 만료 혹은 관리자 로그인이 안 되어있는데 접근하려할 때의 메소드
	public Model notAdminLogin(Model model) {
		String alert = "관리자로그인을 해주세요.";
		String path = "index2.jsp";
		model.addAttribute("alert", alert);
		model.addAttribute("path", path);
		return model;
	}
	
	
	//get방식으로 접근했을 때
//	@RequestMapping(value = "/onlineStore.do", method = RequestMethod.GET)
//	public void firstStepLoginGet(HttpServletResponse response) throws IOException {
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<script>alert('잘못된 접근입니다.');");
//		out.println("location.href = 'index2.jsp';</script>");
//		out.flush();
//	}
	
	
	//post방식으로 접근했을 때
	@RequestMapping(value = "/onlineStore.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String firstStepLogin(Model model, HttpSession session, HttpServletResponse response) throws IOException {
		System.out.println("onlineStore.do 메소드");
		
		StoreVO store = new StoreVO();
		store.setStore_code("online");
		session.setAttribute("admin", store);
		
		if(session.getAttribute("admin") == null) {
			notAdminLogin(model);
			return "../alert.jsp";
		}
		
		
		Map<String, Integer> sales = new HashMap<String, Integer>();
		
		
		
		//월별 온라인 모든(책, 굿즈) 판매 내역 
		
		//1.책
		int onlineMonthBookSales = onlineStoreService.onlineMonthBookSales(store_code);
		System.out.println("onlineMonthBookSales : " + onlineMonthBookSales);
		sales.put("onlineMonthBookSales", onlineMonthBookSales);
		
		//2.굿즈
		int onlineMonthGoodsSales = onlineStoreService.onlineGoodsSales(store_code);
		System.out.println("onlineMonthGoodsSales : " + onlineMonthGoodsSales);
		sales.put("onlineMonthGoodsSales", onlineMonthGoodsSales);
		
		//월별 모든 지점 모든(책, 굿즈) 판매 내역 
		
		//1.책
		int allMonthBookSales = onlineStoreService.allMonthBookSales();
		System.out.println("allMonthBookSales : " + allMonthBookSales);
		sales.put("allMonthBookSales", allMonthBookSales);
		
		//2.굿즈
		int allMonthGoodsSales = onlineStoreService.allMonthGoodsSales();
		System.out.println("allMonthGoodsSales : " + allMonthGoodsSales);
		sales.put("allMonthGoodsSales", allMonthGoodsSales);
		
		
		
		//일별 온라인 모든(책, 굿즈) 판매 내역
		
		//1.책
		int onlineDayBookSales = onlineStoreService.onlineDayBookSales(store_code);
		System.out.println("onlineDayBookSales : " + onlineDayBookSales);
		sales.put("onlineDayBookSales", onlineDayBookSales);
		
		//2.굿즈
		int onlineDayGoodsSales = onlineStoreService.onlineDayGoodsSales(store_code);
		System.out.println("onlineDayGoodsSales : " + onlineDayGoodsSales);
		sales.put("onlineDayGoodsSales", onlineDayGoodsSales);
		
		//일별 모든 지점 모든(책, 굿즈) 판매 내역
		//1.책
		int allDayBookSales = onlineStoreService.allDayBookSales();
		System.out.println("allDayBookSales : " + allDayBookSales);
		sales.put("allDayBookSales", allDayBookSales);
		
		//2.굿즈
		int allDayGoodsSales = onlineStoreService.allDayGoodsSales();
		System.out.println("allDayGoodsSales : " + allDayGoodsSales);
		sales.put("allDayGoodsSales", allDayGoodsSales);
		
		
		model.addAttribute("sales", sales);
		
		
		return "onlineAdmin.jsp";
	}
	
	
	//상품관리
	
	//1.상품입고
	@RequestMapping("/addBookORGoods.do")
	public String officeNewBook(Model model) {
		System.out.println(">> 상품입고페이지 이동");
		
		List<BookVO> categoryCode = bookOfficeService.getCategoryCode();
		System.out.println(categoryCode);
		model.addAttribute("categoryCode", categoryCode);
		
		return "addBookORGoods.jsp";
	}
	
	
	
	
	
	
	
}
