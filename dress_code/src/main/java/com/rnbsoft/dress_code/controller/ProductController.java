package com.rnbsoft.dress_code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

        @GetMapping("/product")
        public String getProduct() {
                return "/product";
        }
        
        //상의 화면 이동 
        @GetMapping("/productUP")
        public String getProductUP() {
                return "/productUP";
        }
        
        //히의 화면 이동 
        @GetMapping("/productBOTTOMS")
        public String getProductBOTTOMS() {
                return "/productBOTTOMS";
        }
        
        //신발 화면 이동 
        @GetMapping("/productShoes")
        public String getProductShoes() {
                return "/productShoes";
        }
}
