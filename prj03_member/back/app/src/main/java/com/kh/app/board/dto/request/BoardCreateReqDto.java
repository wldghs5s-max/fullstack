package com.kh.app.board.dto.request;

import com.kh.app.board.entity.BoardEntity;
import com.kh.app.member.entity.MemberEntity;
import lombok.Getter;

@Getter
public class BoardCreateReqDto {
    private String title;
    private String content;

    public BoardEntity toEntity(MemberEntity memberEntity){
        return BoardEntity.builder()
                .title(title)
                .content(content)
                .writer(memberEntity)
                .build();
    }
}
