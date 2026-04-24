package com.kh.app.board.entity;

import com.kh.app.common.entity.BaseEntity;
import com.kh.app.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "BOARD")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(generator = "seq_board_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_board_gen",sequenceName = "SEQ_BOARD", allocationSize = 1)
    private Long id;
    @Column(nullable = false,length = 200)
    private String title;
    @Column(nullable = false)
    @Lob
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WRITER_ID", nullable = false)
    private MemberEntity writer;
}
