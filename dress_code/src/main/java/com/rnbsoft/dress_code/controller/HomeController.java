package com.rnbsoft.dress_code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

        @GetMapping("/")
        public String getIndex()
        {
        	System.out.println("메인화면 이동");
        	return "home"; 
        }
}
