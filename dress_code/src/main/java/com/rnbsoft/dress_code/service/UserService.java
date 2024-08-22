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

    // 모든 유저 정보 조회
    public List<UserDTO> selectAllUsers(){
        List<UserDTO> usersList = userMapper.selectAllUsers();
        return usersList;
    }
}
