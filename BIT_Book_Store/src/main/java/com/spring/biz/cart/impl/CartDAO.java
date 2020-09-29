package com.spring.biz.cart.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.cart.CartVO;

@Repository
public class CartDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public CartDAO(){
		System.out.println(">>CartDAO 객체생성");
	};
	
	public int insertCart(Map<String, Object> cartmap) {
		int cartvo = mybatis.insert("cartmapper.insertCart", cartmap);
		return cartvo;
		
	}
	
	public void updateCart(CartVO vo) {
		mybatis.update("cartmapper.updateCart", vo);
	}
	
	public void deleteCart(CartVO vo) {
		mybatis.delete("cartmapper.deleteCart", vo);
	}
	
	
	public CartVO getCart(CartVO vo) {
		return mybatis.selectOne("cartmapper.selectCart", vo);
	}
	
	public List<CartVO> getCartList(){
		return mybatis.selectList("cartmapper.selectCartList");
	}

	public int checkSame(HashMap<String, Object> cartmap) {
		return mybatis.selectOne("cartmapper.checkSame",cartmap);
	}
	
	
	
}
