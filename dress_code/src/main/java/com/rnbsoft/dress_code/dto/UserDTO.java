package com.rnbsoft.dress_code.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserDTO {
    private String userName;            // 이름
    private String userId;                  // 아이디
    private String userPassword;     // 비밀번호
    private String userEmail;             // 이메일
    private String userMovTel;         // 전화번호
    private String userAddr;             // 주소
}
