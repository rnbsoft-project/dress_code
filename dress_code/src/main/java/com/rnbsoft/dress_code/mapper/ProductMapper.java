package com.rnbsoft.dress_code.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rnbsoft.dress_code.dto.productDTO;



@Mapper
public interface ProductMapper {

	// 상품 전체 목록 불러오기
    List<productDTO> selectAllProduct();
}
