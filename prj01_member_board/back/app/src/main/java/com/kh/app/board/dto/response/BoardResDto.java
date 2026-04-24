package com.kh.app.board.dto.response;

import com.kh.app.board.entity.BoardEntity;
import com.kh.app.member.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BoardResDto {
    private Long id;
    private String title;
    private String content;
    private String writerNick;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static BoardResDto from(BoardEntity entity){
        return BoardResDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writerNick(entity.getWriter().getNick())
                .createdAt(entity.getCreatedAt())
                .modifiedAt(entity.getModifiedAt())
                .build();
    }
}
