package com.spring.biz.jego;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jegoService")
public class JegoServiceImpl implements JegoService {
	
	@Autowired
	private JegoDAO jegodao;
//	@Override
//	public void insertjego(JegoVO vo) {
//		jegodao.insertJego(vo);
//		
//	}
//
//	@Override
//	public void updatejego(JegoVO vo) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deletejego(JegoVO vo) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public List<JegoVO> getjego(int book_no) {
		return jegodao.getJego(book_no);
		
	}


	@Override
	public JegoVO getJego(String store_code) {
		return jegodao.getJego(store_code);
	}


	@Override
	public JegoVO getJego2(String store_code) {
		return jegodao.getJego2(store_code);
	}

}
