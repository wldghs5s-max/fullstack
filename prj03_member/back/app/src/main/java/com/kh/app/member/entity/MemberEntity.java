package com.kh.app.member.entity;

import com.kh.app.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "MEMBER")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100 ,unique = true)
    private String username;
    @Column(length = 100,nullable = false)
    private String password;
    @Column(length = 100,nullable = false)
    private String nick;

    private String role;

}
