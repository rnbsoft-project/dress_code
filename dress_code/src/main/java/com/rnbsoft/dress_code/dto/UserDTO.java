package com.rnbsoft.dress_code.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserDTO {
    private String userId;          // 아이디
    private String userName;        // 이름
    private String userAddr;     // 주소
    private String userMovTel;       // 전화번호
}
