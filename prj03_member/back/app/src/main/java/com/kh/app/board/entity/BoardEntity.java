package com.kh.app.board.entity;

import com.kh.app.board.dto.request.BoardCreateReqDto;
import com.kh.app.common.entity.BaseEntity;
import com.kh.app.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "BOARD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false , columnDefinition = "text")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WRITER_ID", nullable = false)
    private MemberEntity writer;

    public void update(BoardCreateReqDto dto) {
        if (dto.getTitle() != null){
            title = dto.getTitle();
        }
        if (dto.getContent() != null){
            content = dto.getContent();
        }
    }
}
