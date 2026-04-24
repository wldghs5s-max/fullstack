package com.kh.app.member.dto.response;

import com.kh.app.member.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MemberResDto {
    private Long id;
    private String username;
    private String nick;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static MemberResDto from(MemberEntity entity){
        return MemberResDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .nick(entity.getNick())
                .createdAt(entity.getCreatedAt())
                .modifiedAt(entity.getModifiedAt())
                .build();
    }

}
