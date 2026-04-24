package com.kh.app.member.entity;

import com.kh.app.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "MEMBER")
@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity extends BaseEntity {
    @Id
    @SequenceGenerator(name = "seq_member_gen", allocationSize = 1, sequenceName = "SEQ_MEMBER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_member_gen")
    private Long id;
    @Column(nullable = false, length = 100 ,unique = true)
    private String username;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 100, unique = true)
    private String nick;

}
