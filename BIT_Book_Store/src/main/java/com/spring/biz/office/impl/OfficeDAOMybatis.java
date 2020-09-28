package com.spring.biz.office.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.office.OfficeVO;

@Repository("OfficeDAOMybatis")
public class OfficeDAOMybatis {

	@Autowired
	public SqlSessionTemplate mybatis;

	public OfficeDAOMybatis() {
		System.out.println(">> OfficeDAOMybatis 객체 생성");
	}
	
	public int getOfficeSales() {
		System.out.println(">> MyBatis로 getOfficeSales 실행");
		
		return mybatis.selectOne("officeDAO.getOfficeSales");
	}
	
	
	//주문내역조회
	public List<OfficeVO> getOrderList(String office_no) {
		System.out.println("-----> Mybatis로 getOfficeOrderList() 실행");
		System.out.println(office_no);
		return mybatis.selectList("officeDAO.getOrderList", office_no);
	}
	
	//보유 책 리스트 조회
	public List<OfficeVO> officeBookList(String office_no){
		System.out.println("-----> Mybatis로 getBookList() 실행");
		System.out.println(office_no);
		return mybatis.selectList("officeDAO.officeBookList", office_no);
	}
	
	//오늘 판매금액 조회
	public int todaySalesValue(String office_no) {
		System.out.println("-----> Mybatis로 todaySalesValue() 실행");
		return mybatis.selectOne("officeDAO.todaySalesValue", office_no);
	}
	
	//월 판매금액 조회
	public int monthSalesValue(String office_no) {
		System.out.println("-----> Mybatis로 monthSalesValue() 실행");
		return mybatis.selectOne("officeDAO.monthSalesValue", office_no);
	}
	
	//한달동안의 매출 표시
	public List<OfficeVO> monthTOTCost(String office_no){
		System.out.println("-----> Mybatis로 monthTOTCost() 실행");
		return mybatis.selectList("officeDAO.monthTOTCost", office_no);
	}
}
