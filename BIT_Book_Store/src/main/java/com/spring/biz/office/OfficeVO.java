package com.spring.biz.office;

import java.sql.Date;

public class OfficeVO {
	//북테이블
	private int book_no;
	private int category_no;
	private String book_name;
	private String book_writer;
	private String book_publisher;
	private int book_price;
	private int book_saleprice;
	private String book_info;
	private Date book_published_date;
	private int book_total_page;
	private Date book_entered_date;
	private int ebook;
	private int book_isbn;
	private String book_img;
	
	//재고테이블
	private int stock_idx;
	private String store_code;
	private int cnt;
	
	//북이미지테이블
	private String img_path;
	//주문테이블
	private int order_no;
	private String order_user_id;
	private String order_recv_name;
	private String order_recv_phone;
	private Date order_date;
	private int order_total_cost;
	private String order_message;
	private String order_recv_street_addr;
	private String order_recv_remaining_addr;
	private int order_recv_zip_code;
	private String state;
	private int order_accu_mileage;
	
	//주문디테일테이블
	private int order_b_no;
	private String order_office_no;
	private int order_b_cnt;
	private int order_delivery_type;
	
	//하루 총 매출
	private int TOTCost;
	
	
	
	public OfficeVO() {
		super();
	}
	
	
	
	public OfficeVO(int book_no, int category_no, String book_name, String book_writer, String book_publisher,
			int book_price, int book_saleprice, String book_info, Date book_published_date, int book_total_page,
			Date book_entered_date, int ebook, int book_isbn, String book_img, int cnt) {
		super();
		this.book_no = book_no;
		this.category_no = category_no;
		this.book_name = book_name;
		this.book_writer = book_writer;
		this.book_publisher = book_publisher;
		this.book_price = book_price;
		this.book_saleprice = book_saleprice;
		this.book_info = book_info;
		this.book_published_date = book_published_date;
		this.book_total_page = book_total_page;
		this.book_entered_date = book_entered_date;
		this.ebook = ebook;
		this.book_isbn = book_isbn;
		this.book_img = book_img;
		this.cnt = cnt;
	}



	public OfficeVO(int order_no, int order_b_no,  String order_user_id, String order_recv_name,
			String order_recv_phone, Date order_date, String book_name, int book_saleprice, int order_b_cnt) {
		super();
		this.order_b_no = order_b_no;
		this.book_name = book_name;
		this.book_saleprice = book_saleprice;
		this.order_no = order_no;
		this.order_user_id = order_user_id;
		this.order_recv_name = order_recv_name;
		this.order_recv_phone = order_recv_phone;
		this.order_date = order_date;
		this.order_b_cnt = order_b_cnt;
	}


	public OfficeVO(Date order_date, int tOTCost) {
		super();
		this.order_date = order_date;
		TOTCost = tOTCost;
	}

	


	
	
	
	public OfficeVO(int book_no, int category_no, String book_name, String book_writer, String book_publisher,
			int book_price, int book_saleprice, String book_info, Date book_published_date, int book_total_page,
			Date book_entered_date, int ebook, int book_isbn, String book_img, int stock_idx, String store_code,
			int cnt, String img_path, int order_no, String order_user_id, String order_recv_name,
			String order_recv_phone, Date order_date, int order_total_cost, String order_message,
			String order_recv_street_addr, String order_recv_remaining_addr, int order_recv_zip_code, String state,
			int order_accu_mileage, int order_b_no, String order_office_no, int order_b_cnt, int order_delivery_type,
			int tOTCost) {
		super();
		this.book_no = book_no;
		this.category_no = category_no;
		this.book_name = book_name;
		this.book_writer = book_writer;
		this.book_publisher = book_publisher;
		this.book_price = book_price;
		this.book_saleprice = book_saleprice;
		this.book_info = book_info;
		this.book_published_date = book_published_date;
		this.book_total_page = book_total_page;
		this.book_entered_date = book_entered_date;
		this.ebook = ebook;
		this.book_isbn = book_isbn;
		this.book_img = book_img;
		this.stock_idx = stock_idx;
		this.store_code = store_code;
		this.cnt = cnt;
		this.img_path = img_path;
		this.order_no = order_no;
		this.order_user_id = order_user_id;
		this.order_recv_name = order_recv_name;
		this.order_recv_phone = order_recv_phone;
		this.order_date = order_date;
		this.order_total_cost = order_total_cost;
		this.order_message = order_message;
		this.order_recv_street_addr = order_recv_street_addr;
		this.order_recv_remaining_addr = order_recv_remaining_addr;
		this.order_recv_zip_code = order_recv_zip_code;
		this.state = state;
		this.order_accu_mileage = order_accu_mileage;
		this.order_b_no = order_b_no;
		this.order_office_no = order_office_no;
		this.order_b_cnt = order_b_cnt;
		this.order_delivery_type = order_delivery_type;
		TOTCost = tOTCost;
	}



	public int getStock_idx() {
		return stock_idx;
	}
	public void setStock_idx(int stock_idx) {
		this.stock_idx = stock_idx;
	}
	public String getStore_code() {
		return store_code;
	}
	public void setStore_code(String store_code) {
		this.store_code = store_code;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public int getTOTCost() {
		return TOTCost;
	}
	public void setTOTCost(int tOTCost) {
		TOTCost = tOTCost;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_writer() {
		return book_writer;
	}
	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public int getBook_saleprice() {
		return book_saleprice;
	}
	public void setBook_saleprice(int book_saleprice) {
		this.book_saleprice = book_saleprice;
	}
	public String getBook_info() {
		return book_info;
	}
	public void setBook_info(String book_info) {
		this.book_info = book_info;
	}
	public Date getBook_published_date() {
		return book_published_date;
	}
	public void setBook_published_date(Date book_published_date) {
		this.book_published_date = book_published_date;
	}
	public int getBook_total_page() {
		return book_total_page;
	}
	public void setBook_total_page(int book_total_page) {
		this.book_total_page = book_total_page;
	}
	public Date getBook_entered_date() {
		return book_entered_date;
	}
	public void setBook_entered_date(Date book_entered_date) {
		this.book_entered_date = book_entered_date;
	}
	public int getEbook() {
		return ebook;
	}
	public void setEbook(int ebook) {
		this.ebook = ebook;
	}
	public int getBook_isbn() {
		return book_isbn;
	}
	public void setBook_isbn(int book_isbn) {
		this.book_isbn = book_isbn;
	}
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public String getOrder_user_id() {
		return order_user_id;
	}
	public void setOrder_user_id(String order_user_id) {
		this.order_user_id = order_user_id;
	}
	public String getOrder_recv_name() {
		return order_recv_name;
	}
	public void setOrder_recv_name(String order_recv_name) {
		this.order_recv_name = order_recv_name;
	}
	public String getOrder_recv_phone() {
		return order_recv_phone;
	}
	public void setOrder_recv_phone(String order_recv_phone) {
		this.order_recv_phone = order_recv_phone;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getOrder_total_cost() {
		return order_total_cost;
	}
	public void setOrder_total_cost(int order_total_cost) {
		this.order_total_cost = order_total_cost;
	}
	public String getOrder_message() {
		return order_message;
	}
	public void setOrder_message(String order_message) {
		this.order_message = order_message;
	}
	public String getOrder_recv_street_addr() {
		return order_recv_street_addr;
	}
	public void setOrder_recv_street_addr(String order_recv_street_addr) {
		this.order_recv_street_addr = order_recv_street_addr;
	}
	public String getOrder_recv_remaining_addr() {
		return order_recv_remaining_addr;
	}
	public void setOrder_recv_remaining_addr(String order_recv_remaining_addr) {
		this.order_recv_remaining_addr = order_recv_remaining_addr;
	}
	public int getOrder_recv_zip_code() {
		return order_recv_zip_code;
	}
	public void setOrder_recv_zip_code(int order_recv_zip_code) {
		this.order_recv_zip_code = order_recv_zip_code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getOrder_accu_mileage() {
		return order_accu_mileage;
	}
	public void setOrder_accu_mileage(int order_accu_mileage) {
		this.order_accu_mileage = order_accu_mileage;
	}
	public int getOrder_b_no() {
		return order_b_no;
	}
	public void setOrder_b_no(int order_b_no) {
		this.order_b_no = order_b_no;
	}
	public String getOrder_office_no() {
		return order_office_no;
	}
	public void setOrder_office_no(String order_office_no) {
		this.order_office_no = order_office_no;
	}
	public int getOrder_b_cnt() {
		return order_b_cnt;
	}
	public void setOrder_b_cnt(int order_b_cnt) {
		this.order_b_cnt = order_b_cnt;
	}
	public int getOrder_delivery_type() {
		return order_delivery_type;
	}
	public void setOrder_delivery_type(int order_delivery_type) {
		this.order_delivery_type = order_delivery_type;
	}
	@Override
	public String toString() {
		return "OfficeVO [book_no=" + book_no + ", category_no=" + category_no + ", book_name=" + book_name
				+ ", book_writer=" + book_writer + ", book_publisher=" + book_publisher + ", book_price=" + book_price
				+ ", book_saleprice=" + book_saleprice + ", book_info=" + book_info + ", book_published_date="
				+ book_published_date + ", book_total_page=" + book_total_page + ", book_entered_date="
				+ book_entered_date + ", ebook=" + ebook + ", book_isbn=" + book_isbn + ", book_img=" + book_img
				+ ", stock_idx=" + stock_idx + ", store_code=" + store_code + ", cnt=" + cnt + ", img_path=" + img_path
				+ ", order_no=" + order_no + ", order_user_id=" + order_user_id + ", order_recv_name=" + order_recv_name
				+ ", order_recv_phone=" + order_recv_phone + ", order_date=" + order_date + ", order_total_cost="
				+ order_total_cost + ", order_message=" + order_message + ", order_recv_street_addr="
				+ order_recv_street_addr + ", order_recv_remaining_addr=" + order_recv_remaining_addr
				+ ", order_recv_zip_code=" + order_recv_zip_code + ", state=" + state + ", order_accu_mileage="
				+ order_accu_mileage + ", order_b_no=" + order_b_no + ", order_office_no=" + order_office_no
				+ ", order_b_cnt=" + order_b_cnt + ", order_delivery_type=" + order_delivery_type + ", TOTCost="
				+ TOTCost + "]";
	}
	
	
	
	
}
