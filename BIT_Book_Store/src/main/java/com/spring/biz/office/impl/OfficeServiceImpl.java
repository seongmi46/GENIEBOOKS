package com.spring.biz.office.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.office.OfficeService;
import com.spring.biz.office.OfficeVO;

@Service("officeService")
public class OfficeServiceImpl implements OfficeService{
	@Autowired //타입이 일치하는 객체(인스턴스) 주입
	private OfficeDAOMybatis officeDAO;
	
	
	@Override
	public List<OfficeVO> getOfficeList() {
		return null;
	}


	@Override
	public int getOfficeSales() {
		
		return officeDAO.getOfficeSales();
	}


	@Override
	public List<OfficeVO> getOrderList(String office_no) {
		
		return officeDAO.getOrderList(office_no);
	}

	//보유 책 리스트 출력
	@Override
	public List<OfficeVO> officeBookList(String office_no) {
		return officeDAO.officeBookList(office_no);
	}

	//오늘 판매금액 출력
	@Override
	public int todaySalesValue(String office_no) {
		return officeDAO.todaySalesValue(office_no);
	}

	//월 판매금액 출력
	@Override
	public int monthSalesValue(String office_no) {
		return officeDAO.monthSalesValue(office_no);
	}


	@Override
	public List<OfficeVO> monthTOTCost(String office_no) {
		return officeDAO.monthTOTCost(office_no);
	}
	
}
