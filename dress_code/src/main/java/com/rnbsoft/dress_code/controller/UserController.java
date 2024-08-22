package com.rnbsoft.dress_code.controller;

import com.rnbsoft.dress_code.dto.UserDTO;
import com.rnbsoft.dress_code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

}
