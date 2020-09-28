package com.bit.bookstore.view.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bit.bookstore.order.OrderService;
import com.bit.bookstore.vo.BookVO;
import com.bit.bookstore.vo.CartBookVO;
import com.bit.bookstore.vo.CartVO;
import com.bit.bookstore.vo.GoodsVO;
import com.bit.bookstore.vo.OrderBookNGoodsNPointVO;
import com.bit.bookstore.vo.OrdersVO;
import com.bit.bookstore.vo.StoreVO;
import com.bit.bookstore.vo.UserVO;

@RestController
@RequestMapping("/soomin/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	public OrderController() {
		System.out.println("-- OrderController() 객체 생성");
	}
	
	
	@RequestMapping(value = "/orderStep0.do", method = RequestMethod.GET)
	public void orderStep0(HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('잘못된 접근입니다.');");
		out.println("location.href = 'index.jsp';</script>");
		out.flush();
	}
	
	
	//온라인, 바로드림
	@RequestMapping(value = "/orderStep0.do", method = RequestMethod.POST)
	public ModelAndView orderStep0(HttpSession session, 
			@RequestParam(required = false) int[] orderbook_no,
			@RequestParam(required = false) int[] ordercart_idx,
			@RequestParam(required = false) int[] NonMemberBook_no,
			@RequestParam(required = false, defaultValue = "0") int orderbook_cnt,
			@RequestParam String store_code,
			ModelAndView mav/* , HttpServletResponse response */) throws IOException {
		//********로그인 되어있으면 세션에 있는 user의 마일리지를 가져옴, 비회원 구매이면 마일리지 가져오는 거 없음
		//********장바구니에서 상품 선택 안 되어 있으면 그 창에서 script로 처리
		String returnViewName;
		
		mav.addObject("store_code", store_code);
		
		
		//굿즈 리스트 가져오기(현재 시간에 파는 굿즈만)
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
		Date date = new Date();
		String nowDate = format.format(date);
		List<GoodsVO> goodsList = orderService.getGoodsList(nowDate);
		
		mav.addObject("goodsList", goodsList);
		System.out.println("goodsList : " + goodsList);
		System.out.println("orderbook_cnt : " + orderbook_cnt);
		System.out.println("orderbook_no : " + Arrays.toString(orderbook_no));
		
		//orderbook_no가 있으면 바로구매
		//orderbook_cnt가 있으면 바로 구매!!!
		if(orderbook_cnt != 0) {//바로구매일 때!!

			mav.addObject("orderbook_cnt", orderbook_cnt);
			System.out.println("바로구매!");
		
		}else {//장바구니에서 구매일 때!!//orderbook_no를 지정해줘야함
			
			List<CartBookVO> orderBookList = null;
			
			if(session.getAttribute("user") != null) {//회원이면
				
				//선택한 책들의 정보를 BookVO로 저장
				orderBookList = orderService.getOrderCartList(ordercart_idx);
				
				System.out.println("장바구니에서구매!");
				
			
			
			}else {//회원이 아니면
				System.out.println("비회원");
				@SuppressWarnings("unchecked")
				List<CartVO> nonMemberCart = (List<CartVO>)session.getAttribute("nonMemberCart");
				List<CartVO> nonMemberCartOrder = new ArrayList<CartVO>();
				
				System.out.println(Arrays.toString(NonMemberBook_no));
				for(int i = 0; i < NonMemberBook_no.length; i++) {
					for(int k = 0; k < nonMemberCart.size(); k++) {
						if(NonMemberBook_no[i] == nonMemberCart.get(k).getBook_no()) {
							nonMemberCartOrder.add(nonMemberCart.get(k));
							System.out.println(("nonMemberCartOrder : " + nonMemberCartOrder));
						}
					}
				}
				
				orderBookList = orderService.getNonMemberOrderList(nonMemberCartOrder);
			}
			
			System.out.println("orderBookList : " + orderBookList);
			mav.addObject("orderBookList", orderBookList);
			
			orderbook_no = new int[orderBookList.size()];
			
			
			for(int i = 0; i < orderbook_no.length; i++) {
				orderbook_no[i] = orderBookList.get(i).getBook_no();
			}
			
		}
		
		
		
		
		
		
		
		
		
//		if(orderbook_no == null) {//잘못된 접근일 시 장바구니로 
//			response.setContentType("text/html; charset=UTF-8;");
//			PrintWriter out = response.getWriter();
//			out.println("<script>alert('잘못된 접근입니다.');");
//			out.println("location.href = 'index.jsp';</script>");
//			out.flush();
//		}
		System.out.println("선택한 책의 포인트 가져오기");
		//선택한 책의 포인트(책 판매가의 5%) 가져오기
		int saleprices = orderService.getOrderBookSalePrice(orderbook_no);
		
		int point = saleprices / 20;
		int totalPoint = point;
		
		
		
		
		//회원이면
		if(session.getAttribute("user") != null) {
			System.out.println("회원");
			totalPoint += ((UserVO) session.getAttribute("user")).getPoint();
			
			
		}else {
			System.out.println("비회원");
		}
		
		
		
		mav.addObject("orderbook_no", orderbook_no);
		mav.addObject("point", point);
		mav.addObject("totalPoint", totalPoint);
		System.out.println("point : " + point);
		returnViewName = "goodsSelect.jsp";

		
		
		mav.setViewName(returnViewName);
		return mav;
		
	}
	
	@RequestMapping(value = "/orderStep1.do", method = RequestMethod.GET)
	public void orderStep1(HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("잘못된 접근입니다.");
		out.println("location.href='index.jsp';");
		out.println("</script>");
		out.flush();
	}
	
	
	
	
	
	//online배송일 때 오는 메소드
	//orderbook_no -> 바로구매일 때 전달 됨
	//ordercart_no -> 장바구니 구매일 때 전달 됨
	@RequestMapping(value = "/orderStep1.do", method = RequestMethod.POST)
	public ModelAndView orderStemp1(
			@ModelAttribute("bgp") OrderBookNGoodsNPointVO bgp,//사은품 구매 후 포인트 내역
			@RequestParam(required = false) int[] orderbook_no,//바로구매일 때 전달
			@RequestParam(required = false) int[] ordercart_idx,// 장바구니 구매일 때 전달
			@RequestParam(required = false, defaultValue = "0") int orderbook_cnt,//바로구매일 때 전달
			@RequestParam int point,
			@RequestParam String store_code,
			@RequestParam(required = false) int[] NonMemberBook_no,
			ModelAndView mav,
			HttpSession session) {
		System.out.println("사은품 구매 후 내역 : " + bgp.toString());
		
//		//orderbook_no의 BookVO만들기
		mav.addObject("point", point);
		mav.addObject("store_code", store_code);
		
		List<GoodsVO> orderGoodsVOList = new ArrayList<GoodsVO>();
		
		
		//bgp(선택한 사은품)의 goods_code를 가지고 GoodsVO 리스트 불러오기
		if(bgp.getGoods_code() == null) {
			
		}else {
			orderGoodsVOList = orderService.getOrderGoodsVOList(bgp.getGoods_code());
		}
		
		System.out.println("선택한 굿즈의 리스트 : " + orderGoodsVOList);
		
		mav.addObject("orderGoodsVOList", orderGoodsVOList);//선택한 굿즈VO
		
		System.out.println(Arrays.toString(orderbook_no));
		int bookSort;//책 종류 개수
		int booksAll_cnt = 0;//총 주문하려는 책 개수
		
		
		if(orderbook_cnt != 0) {//바로구매일 때
			System.out.println("바로구매!");
			
			
			
			
			
			mav.addObject("orderbook_cnt", orderbook_cnt);
			
			
			booksAll_cnt = orderbook_cnt;
			System.out.println("바로구매시 booksAll_cnt : " + booksAll_cnt);
		}else {
			System.out.println("장바구니에서구매!");
			if(session.getAttribute("user") != null) {//회원일 때
				
				
				
				
				UserVO user = (UserVO)session.getAttribute("user");
				
				StringTokenizer stringTokenizer = new StringTokenizer(user.getPhone_number1(), "-");
				List<String> phoneNumberList = new ArrayList<String>();
				
				while(stringTokenizer.hasMoreTokens()) {
					phoneNumberList.add(stringTokenizer.nextToken());
				}
				
				System.out.println("phoneNumberList : " + phoneNumberList);
				mav.addObject("phoneNumberList", phoneNumberList);
				
				
				List<CartBookVO> orderCartList = orderService.getOrderCartList(ordercart_idx);
				System.out.println("orderCartList : " + orderCartList);
				mav.addObject("orderCartList", orderCartList);
				orderbook_no = new int[orderCartList.size()];
				
				for(int i = 0; i < orderCartList.size(); i++) {
					orderbook_no[i] = orderCartList.get(i).getBook_no();
					booksAll_cnt += orderCartList.get(i).getCnt();
				}
				System.out.println("장바구니 구매시 booksAll_cnt : " + booksAll_cnt);
			}else {//비회원일 때
				//세션에 저장한 장바구니에 넣은 책의 개수 등 정보를 출력
				
				
				List<CartVO> nonMemberCart = (List<CartVO>)session.getAttribute("nonMemberCart");
				List<CartVO> nonMemberCartOrder = new ArrayList<CartVO>();
				
				System.out.println(Arrays.toString(NonMemberBook_no));
				for(int i = 0; i < NonMemberBook_no.length; i++) {
					for(int k = 0; k < nonMemberCart.size(); k++) {
						if(NonMemberBook_no[i] == nonMemberCart.get(k).getBook_no()) {
							nonMemberCartOrder.add(nonMemberCart.get(k));
							System.out.println(("nonMemberCartOrder : " + nonMemberCartOrder));
						}
					}
				}
				
				List<CartBookVO> cartbookvoList = orderService.getNonMemberOrderList(nonMemberCartOrder);
				System.out.println("cartbookvoList : " + cartbookvoList);
				mav.addObject("cartbookvoList", cartbookvoList);
				
				
				for(int i = 0; i < cartbookvoList.size(); i++) {
					booksAll_cnt += cartbookvoList.get(i).getCnt();
				}
				
				
			}
			
		}
		
		
		if(!store_code.equals("online")) {//바로드림일 때 지점 정보 저장해서 넘겨주기
			StoreVO storevo = orderService.getStoreInfo(store_code);
			mav.addObject("storevo", storevo);
		}
		
		
		
		bookSort = orderbook_no.length;
		
		//책 객체 저장하기
		List<BookVO> orderBookList = orderService.getOrderBookVOList(orderbook_no);
		System.out.println("orderBookList : " + orderBookList);
		mav.addObject("orderBookList", orderBookList);
		mav.addObject("bookSort", bookSort);
		mav.addObject("booksAll_cnt", booksAll_cnt);
		
		if(session.getAttribute("user") != null) {//회원일 시 가는 결제 창
			mav.setViewName("UserPay.jsp");
		}else {//비회원일 시 가는 결체 창
			mav.setViewName("NonUserPay.jsp");
		}
		
		
		return mav;
	}
	
	
	
	
	
	@RequestMapping(value = "/orderFinish.do", method = RequestMethod.GET)
	public String OrderFinish(
			@ModelAttribute OrdersVO ordervo,//비회원일 땐 이메일도 같이 옴
			@RequestParam int[] orderbook_no,
			@RequestParam(required = false, defaultValue = "0") int orderbook_cnt,
			@RequestParam(required = false) int[] ordergoods_no,
			@RequestParam String store_code,
			@RequestParam int mypoint,
			@RequestParam(required = false) String basic_addr,
			@RequestParam(required = false) int[] cart_idx,//회원일 때 기본 배송지로 저장하기면 1, 아니면 빈 문자열 넘어옴
			@RequestParam(required = false) String order_nonmem_email,
			HttpSession session) {
			
			System.out.println("**결제 완료 시 나타나는 창");
			System.out.println("ordervo : " + ordervo);
			System.out.println("orderbook_no : " + Arrays.toString(orderbook_no));
			System.out.println("orderbook_cnt : " + orderbook_cnt);
			System.out.println("ordergoods_no : " + Arrays.toString(ordergoods_no));
			System.out.println("store_code : " + store_code);
			System.out.println("mypoint : " + mypoint);
			System.out.println("basic_addr : " + basic_addr);
			
			String order_user_id;
			
			//회원일 때 비회원일 때 아이디 다르게 처리
			if(session.getAttribute("user") != null) {//***********회원일 때
				order_user_id = ((UserVO)session.getAttribute("user")).getId();
				ordervo.setOrder_user_id(order_user_id);
				
				
				if(basic_addr.equals("1")) {//기본배송지로 저장일 시
					orderService.updateBasic_addr(
							ordervo.getOrder_recv_zip_code(), 
							ordervo.getOrder_recv_street_addr(),
							ordervo.getOrder_recv_remaining_addr(),
							order_user_id);
				}
				
				
				
				
				
				
				
				
				
				
				
			}else {//***********비회원일 땐
				order_user_id = "notMember";
				ordervo.setOrder_user_id(order_user_id);
				ordervo.setOrder_nonmem_email(order_nonmem_email);
				
				
				
			}
			System.out.println("ordervo회원 아이디 입력 후 : " + ordervo);
			if(orderbook_cnt == 0) {//장바구니에서 구매일 시
				
				//orderService.insertOrderNonNumber(ordervo, orderbook_no, ordergoods_no, store_code);
				System.out.println("최종 - 장바구니 구매 완료");
				
				
			}else {//바로구매일 시
				
				orderService.insertOrderDirect(ordervo, orderbook_no, orderbook_cnt, ordergoods_no, store_code);
				System.out.println("최종 - 바로구매 완료");
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		return null;
	}
	
	
	
	
	
}
