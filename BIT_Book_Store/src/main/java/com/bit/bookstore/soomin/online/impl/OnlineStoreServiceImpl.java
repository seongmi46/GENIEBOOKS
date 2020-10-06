package com.bit.bookstore.soomin.online.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.bookstore.soomin.online.OnlineStoreService;
import com.bit.bookstore.vo.BookNCategoryVO;
import com.bit.bookstore.vo.BookStockVO;
import com.bit.bookstore.vo.BookVODateToString;
import com.bit.bookstore.vo.GoodsVODateToString;


@Service("onlineStoreService")
public class OnlineStoreServiceImpl implements OnlineStoreService{
	
	@Autowired
	private OnlineStoreDAOMybatis onlineStoreMybatis;

	@Override
	public int onlineMonthBookSales(String store_code) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.onlineMonthBookSales(store_code);
	}

	@Override
	public int onlineGoodsSales(String store_code) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.onlineMonthGoodsSales(store_code);
	}

	@Override
	public int allMonthBookSales() {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.allMonthBookSales();
	}

	@Override
	public int allMonthGoodsSales() {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.allMonthGoodsSales();
	}

	@Override
	public int onlineDayBookSales(String store_code) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.onlineDayBookSales(store_code);
	}

	@Override
	public int onlineDayGoodsSales(String store_code) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.onlineDayGoodsSales(store_code);
	}

	@Override
	public int allDayBookSales() {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.allDayBookSales();
	}

	@Override
	public int allDayGoodsSales() {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.allDayGoodsSales();
	}

	@Override
	public int getCategory_no(String category_code, String category_main, String category_name) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.getCategory_no(category_code, category_main, category_name);
	}

	@Override
	public int insertBook(BookVODateToString bookvo) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.insertBook(bookvo);
	}

	@Override
	public int checkBook(BookVODateToString bookvo) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.checkBook(bookvo);
	}

	@Override
	public int checkGoods(String goods_name) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.checkGoods(goods_name);
	}

	@Override
	public int insertGoods(GoodsVODateToString goodsvo) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.insertGoods(goodsvo);
	}

	@Override
	public int getOnlineTotalCount(String store_code, String search) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.getOnlineTotalCount(store_code, search);
	}

	@Override
	public List<BookStockVO> getBookStockList(int begin, int end, String search) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.getBookStockList(begin, end, search);
	}

	@Override
	public int updateStockCnt(int stock_idx, int cnt) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.updateStockCnt(stock_idx, cnt);
	}

	@Override
	public BookNCategoryVO getBookDetail(int book_no) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.getBookDetail(book_no);
	}

	@Override
	public int updateBook(BookVODateToString bvo) {
		// TODO Auto-generated method stub
		return onlineStoreMybatis.updateBook(bvo);
	}
	
}
