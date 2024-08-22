package com.rnbsoft.dress_code.service;

import com.rnbsoft.dress_code.dto.UserDTO;
import com.rnbsoft.dress_code.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    // @Autowired 대신 객체 생성으로 대체 ( 강한 결합은 권장하지 않음 )
    @Autowired
    private UserMapper userMapper;

    UserDTO users = new UserDTO();

    // 유저 정보 호출
    public List<UserDTO> selectAllUsers(){
        System.out.println("서비스까지 호출");
        List<UserDTO> usersList = userMapper.selectAllUsers();
        return usersList;
    }
}
