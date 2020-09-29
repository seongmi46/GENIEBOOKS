package com.spring.biz.jego;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JegoDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public JegoDAO() {
		System.out.println("JegoDAO 생성");
	}
	
//	public void insertJego(JegoVO vo) {
//		mybatis.insert("jegomapper.insertJego", vo);
//	}
//	
//	public void updateJego(JegoVO vo) {
//		mybatis.update("jegomapper.updateJego", vo);
//	}
//	
//	public void deleteJego(JegoVO vo) {
//		mybatis.update("jegomapper.deleteJego", vo);
//	}
	
	public List<JegoVO> getJego(int book_no ) {
		return mybatis.selectList("jegomapper.getJego", book_no);
	}
	
	public JegoVO getJego(String store_code){
		return mybatis.selectOne("jegomapper.getJego",store_code);
	}
	
	public JegoVO getJego2(String store_code){
		return null;
	}
	
}
