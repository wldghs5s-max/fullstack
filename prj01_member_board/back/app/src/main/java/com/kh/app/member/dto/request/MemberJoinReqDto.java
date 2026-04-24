package com.kh.app.member.dto.request;

import com.kh.app.member.entity.MemberEntity;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MemberJoinReqDto {
    private String username;
    private String password;
    private String nick;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .username(username)
                .password(password)
                .nick(nick)
                .build();
    }

}
