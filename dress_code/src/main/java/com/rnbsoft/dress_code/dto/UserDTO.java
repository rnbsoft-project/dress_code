package com.rnbsoft.dress_code.dto;

import lombok.*;

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
    private String socialYn;               // 소셜로그인 여부
}
