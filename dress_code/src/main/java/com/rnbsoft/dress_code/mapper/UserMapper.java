package com.rnbsoft.dress_code.mapper;
import com.rnbsoft.dress_code.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface UserMapper {

    // 유저 전체 목록 불러오기
    List<UserDTO> selectAllUsers();

    // 유저 회원가입
    void userSave(UserDTO userDTO);
}
