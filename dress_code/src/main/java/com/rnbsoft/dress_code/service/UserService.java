package com.rnbsoft.dress_code.service;

import com.rnbsoft.dress_code.dto.UserDTO;
import com.rnbsoft.dress_code.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // 유저 회원가입
    public void userSave( UserDTO userDTO )
    { userMapper.userSave(userDTO); }

    // 유저 회원가입 유효성 체크
    public int userIdChk( String userId )
    { return userMapper.userIdChk(userId); }

    // 유저 로그인
    public Map<UserDTO, String> userLogin(String userId, String userPassword ) {
        Map<UserDTO, String> userMap = userMapper.userLogin(userId, userPassword);
        return userMap;
    }

    // 카카오 로그인
    public void kakaoSave(UserDTO userDTO) {
        userMapper.kakaoSave(userDTO);
    }

    // 카카오 소셜 로그인 여부 확인
    public String kakaoSocialYn(String userId) {
        return userMapper.kakaoSocialYn(userId);
    }

    // 모든 유저 정보 조회 ( JDBC 연결 테스트용 메소드 )
    public List<UserDTO> selectAllUsers()
    { return userMapper.selectAllUsers(); }
}
