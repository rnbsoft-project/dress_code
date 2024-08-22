package com.rnbsoft.dress_code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicesController {

        @GetMapping("/services")
        public String getService() {
                return "services";
        }
}
