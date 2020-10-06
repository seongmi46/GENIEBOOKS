package com.spring.biz.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CartService {
	int insertCart(Map<String,Object> cartmap);
	void updateCart(CartVO vo);
	void deleteCart(CartVO vo);
	CartVO getCart(CartVO vo);
	List<CartVO> getCartlist();
	int checkSame(HashMap<String, Object> cartmap);
}
