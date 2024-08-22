package com.rnbsoft.dress_code.mapper;
import com.rnbsoft.dress_code.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDTO> selectAllUsers();
}
