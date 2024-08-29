package com.rnbsoft.dress_code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rnbsoft.dress_code.dto.productDTO;
import com.rnbsoft.dress_code.mapper.ProductMapper;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductMapper prodMapper;
	
	//전체 상품 조회
	public List<productDTO> selectAllProdut(){
		return prodMapper.selectAllProduct();
	}
}
