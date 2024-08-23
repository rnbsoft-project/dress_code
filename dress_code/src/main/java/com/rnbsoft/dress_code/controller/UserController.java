package com.rnbsoft.dress_code.controller;

import com.rnbsoft.dress_code.dto.UserDTO;
import com.rnbsoft.dress_code.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    // 유저 로그인화면 이동
    @GetMapping("/loginForm")
    public String getLogin() {
        return "loginForm";
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


    // 회원가입 유효성 체크
    @PostMapping("/userIdChk")
    @ResponseBody
    public int userJoinStatusChk(@RequestParam String userId) {
        return userService.userIdChk(userId);
    }


    // 유저 로그인
    @PostMapping("/userLogin")
    @ResponseBody
    public ModelAndView userLogin(@RequestParam(value ="requestUserId", required = false) String requestUserId,
                                                            @RequestParam("requestUserPassword") String requestUserPassword,
                                                            HttpSession session)
    {
        // DB에 유저 ID로 가입된 계정이 있는지 확인
        Map<UserDTO, String> userMap = new HashMap<>();

        userMap = userService.userLogin(requestUserId, requestUserPassword);
        String userId = userMap.get("USER_ID");
        String userPassword = userMap.get("USER_PASSWORD");
        String userName = userMap.get("USER_NAME");

        if(requestUserId.equals(userId) && requestUserPassword.equals(userPassword)) {
            // 로그인 성공 시, HOME 페이지로 이동
            session.setAttribute("userName", userName);
            return new ModelAndView("redirect:/");
        } else {
            // 로그인 실패 시, 로그인 페이지로 이동
            ModelAndView model = new ModelAndView("loginForm");
            model.addObject("userName", userName);
            model.addObject("loginError", true);
            return model;
        }
    }


    // 유저 로그아웃
    @PostMapping("/logout")
    public String userLogout(HttpSession session) {
        session.invalidate();       // 세션 무효화( 로그아웃 처리 )
        return "redirect:/";
    }
}