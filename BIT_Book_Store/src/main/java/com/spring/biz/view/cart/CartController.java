package com.spring.biz.view.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.biz.cart.CartService;
import com.spring.biz.cart.CartVO;

@Controller
@SessionAttributes("cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	public CartController() {
		System.out.println("---> CartControlller() 객체 생성");
	}
	
//	@RequestMapping(value="/cart.do", method= RequestMethod.POST)
//	public String cart(CartVO vo) {
//		System.out.println("CartVO vo : " + vo);
//		cartService.insertCart(vo);
//		return "cart.jsp";
//	}
	
	
	
	
}
