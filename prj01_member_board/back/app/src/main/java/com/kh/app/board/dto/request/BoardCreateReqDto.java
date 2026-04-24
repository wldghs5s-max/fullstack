package com.kh.app.board.dto.request;

import com.kh.app.board.entity.BoardEntity;
import com.kh.app.member.entity.MemberEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoardCreateReqDto {
    private Long writerId;
    private String title;
    private String content;

    public BoardEntity toEntity(MemberEntity writer){
        if (writer==null){
            throw new EntityNotFoundException("writer is null~~~");
        }
        return BoardEntity.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }
}
