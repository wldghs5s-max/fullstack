package com.kh.app.board.dto.response;

import com.kh.app.board.entity.BoardEntity;
import com.kh.app.common.entity.BaseEntity;
import com.kh.app.member.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class BoardRespDto {

    private Long id;
    private String title;
    private String content;
    private String writerNick;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String delYn;


    public static BoardRespDto from(BoardEntity entity){
        return BoardRespDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writerNick(entity.getWriter().getNick())
                .createdAt(entity.getCreatedAt())
                .modifiedAt(entity.getModifiedAt())
                .delYn(entity.getDelYn())
                .build();
    }

}
