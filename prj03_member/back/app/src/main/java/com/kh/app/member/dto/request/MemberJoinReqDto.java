package com.kh.app.member.dto.request;

import com.kh.app.member.entity.MemberEntity;
import lombok.Getter;

@Getter
public class MemberJoinReqDto {

    private String username;
    private String password;
    private String nick;
    private String role;

    public MemberEntity toEntity(String encodedPw){
        return MemberEntity.builder()
                .username(username)
                .password(encodedPw)
                .nick(nick)
                .role(role)
                .build();
    }

}
