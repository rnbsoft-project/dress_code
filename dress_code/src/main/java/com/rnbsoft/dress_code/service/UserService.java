package com.rnbsoft.dress_code.service;

import com.rnbsoft.dress_code.dto.UserDTO;
import com.rnbsoft.dress_code.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // 유저 회원가입
    public void userSave(UserDTO userDTO) {
        userMapper.userSave(userDTO);
    }

    // 유저 회원가입 유효성 체크
    public int userIdChk(String userId ) {
        int check = userMapper.userIdChk(userId);
        System.out.println(check);
        return userMapper.userIdChk(userId);
    }



    // 모든 유저 정보 조회
    public List<UserDTO> selectAllUsers(){
        List<UserDTO> usersList = userMapper.selectAllUsers();
        return usersList;
    }
}
