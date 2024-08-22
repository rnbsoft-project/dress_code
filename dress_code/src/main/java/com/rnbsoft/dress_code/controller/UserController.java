package com.rnbsoft.dress_code.controller;

import com.rnbsoft.dress_code.dto.UserDTO;
import com.rnbsoft.dress_code.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    // 유저 로그인화면 이동
    @GetMapping("login")
    public String getLogin() {
        return "login";
    }

    // 유저 회원가입 화면 이동
    @GetMapping("/join")
    public String getJoin() {
        return "join";
    }

    // 유저 회원가입
    @PostMapping("/userSave")
    @ResponseBody
    public void userSave(@RequestBody UserDTO userDTO) {
        userService.userSave(userDTO);
    }
}
