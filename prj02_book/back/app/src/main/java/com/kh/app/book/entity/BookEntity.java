package com.kh.app.book.entity;

import com.kh.app.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "BOOK")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 100, nullable = false)
    private Integer price;

}
