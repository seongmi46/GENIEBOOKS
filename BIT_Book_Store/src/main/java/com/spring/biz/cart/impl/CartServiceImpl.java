package com.spring.biz.cart.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.cart.CartService;
import com.spring.biz.cart.CartVO;

@Service("cartService")
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDAO cartdao;
	@Override
	public int insertCart(Map<String, Object> cartmap) {
		int cartvo = cartdao.insertCart(cartmap);
		return cartvo;
		
	}

	@Override
	public void updateCart(CartVO vo) {
		cartdao.updateCart(vo);
		
	}

	@Override
	public void deleteCart(CartVO vo) {
		cartdao.deleteCart(vo);
	}

	@Override
	public CartVO getCart(CartVO vo) {
		return cartdao.getCart(vo);
	}

	@Override
	public List<CartVO> getCartlist() {
		return cartdao.getCartList();
	}

	@Override
	public int checkSame(HashMap<String, Object> cartmap) {
		return cartdao.checkSame(cartmap);
		
	}

}
