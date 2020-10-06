package com.bit.bookstore.soomin.online;

import java.util.List;

import com.bit.bookstore.vo.BookNCategoryVO;
import com.bit.bookstore.vo.BookStockVO;
import com.bit.bookstore.vo.BookVODateToString;
import com.bit.bookstore.vo.GoodsVODateToString;

public interface OnlineStoreService {

	int onlineMonthBookSales(String store_code);

	int onlineGoodsSales(String store_code);

	int allMonthBookSales();

	int allMonthGoodsSales();

	int onlineDayBookSales(String store_code);

	int onlineDayGoodsSales(String store_code);

	int allDayBookSales();

	int allDayGoodsSales();

	int getCategory_no(String category_code, String category_main, String category_name);

	int insertBook(BookVODateToString bookvo);

	int checkBook(BookVODateToString bookvo);

	int checkGoods(String goods_name);

	int insertGoods(GoodsVODateToString goodsvo);

	int getOnlineTotalCount(String store_code, String search);

	List<BookStockVO> getBookStockList(int begin, int end, String search);

	int updateStockCnt(int stock_idx, int cnt);

	BookNCategoryVO getBookDetail(int book_no);

	int updateBook(BookVODateToString bvo);

}
