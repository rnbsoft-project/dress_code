package com.rnbsoft.dress_code.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor

@AllArgsConstructor
@ToString
@Getter
@Setter
public class productDTO {

	private String prodNum; //상품번호
	private String prodName; //상품이름
	private String prodCatgr; //상품카테고리
	private String prodImgUrl; //상품이미지url

}
