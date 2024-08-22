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

import java.util.List;

@Controller
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/join")
    public String getJoin() {
        return "join";
    }
    @PostMapping("/userSave")
    @ResponseBody
    public void getJoin(@RequestBody UserDTO userDTO) {
        System.out.println("회원가입 Controller 시작");
        String userName             = userDTO.getUserName();
        String userId                   = userDTO.getUserId();
        String userPassword      = userDTO.getUserPassword();
        String userEmail             = userDTO.getUserEmail();
        String userMovTelNo     = userDTO.getUserMovTel();
        String userAddr              = userDTO.getUserAddr();

        System.out.println("유저 이름 : " + userName);
        System.out.println("유저 아이디 : " + userId);
        System.out.println("유저 비밀번호 : " + userPassword);
        System.out.println("유저 이메일 : " + userEmail);
        System.out.println("유저 전화번호 : " + userMovTelNo);
        System.out.println("유저 주소 : " + userAddr);

        userService.userJoin(userDTO);
    }

    @GetMapping("/users")
    public String getUsers(){
        List<UserDTO> userAllList = userService.selectAllUsers();
        return "contact";
    }
}
