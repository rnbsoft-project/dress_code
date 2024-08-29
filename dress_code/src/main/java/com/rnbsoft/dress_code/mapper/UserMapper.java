package com.rnbsoft.dress_code.mapper;
import com.rnbsoft.dress_code.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    // 유저 전체 목록 불러오기
    List<UserDTO> selectAllUsers();

    // 유저 회원가입
    void userSave( UserDTO userDTO );

    // 유저 중복아이디 체크
    int userIdChk( String userId );

    // 유저 로그인
    Map<UserDTO, String> userLogin(String userId, String userPassword );

    // 카카오 로그인
    void kakaoSave(UserDTO userDTO);
}
