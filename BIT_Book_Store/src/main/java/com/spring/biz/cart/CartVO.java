package com.spring.biz.cart;
/*
 CREATE TABLE CART
(
    cart_idx      NUMBER             NOT NULL, 
    user_id       VARCHAR2(30)    NOT NULL, 
    book_no       NUMBER          NOT NULL, 
    cnt           NUMBER          NOT NULL, 
    store_code    VARCHAR2(30)    NOT NULL, 
    CONSTRAINT CART_PK PRIMARY KEY (cart_idx)
) 
  
 */
public class CartVO {
	private int cart_idx, book_no, cnt;
	private String user_id, store_code;
	
	public CartVO() {
		System.out.println(">>CartVO 객체생성");
	}

	public int getCart_idx() {
		return cart_idx;
	}

	public void setCart_idx(int cart_idx) {
		this.cart_idx = cart_idx;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getStore_code() {
		return store_code;
	}

	public void setStore_code(String store_code) {
		this.store_code = store_code;
	}

	@Override
	public String toString() {
		return "CartVO [cart_idx=" + cart_idx + ", book_no=" + book_no + ", cnt=" + cnt + ", user_id=" + user_id
				+ ", store_code=" + store_code + "]";
	}
	
	
	
	
	
}
