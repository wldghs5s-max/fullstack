package com.kh.app.member.dto.response;

import com.kh.app.member.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MemberResDto {

    public Long id;
    public String username;
    public String password;
    public String nick;
    public String role;
    public LocalDateTime createdAt;
    public LocalDateTime modifiedAt;
    public String delYn;

    public static MemberResDto from(MemberEntity entity) {
        return MemberResDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .nick(entity.getNick())
                .role(entity.getRole())
                .createdAt(entity.getCreatedAt())
                .modifiedAt(entity.getModifiedAt())
                .delYn(entity.getDelYn())
                .build();
    }

}


