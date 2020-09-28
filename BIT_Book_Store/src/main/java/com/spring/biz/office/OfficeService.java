package com.spring.biz.office;

import java.util.List;

public interface OfficeService {
	List<OfficeVO> getOfficeList();
	
	int getOfficeSales();
	//주문리스트
	List<OfficeVO> getOrderList(String office_no);
	
	//보유 책 리스트
	List<OfficeVO> officeBookList(String office_no);
	
	//오늘 판매금액
	int todaySalesValue(String office_no);
	
	//월 판매금액
	int monthSalesValue(String office_no);
	
	//한달 매출 표시
	List<OfficeVO> monthTOTCost(String office_no);
}
