package com.kh.app.book.dto.response;

import com.kh.app.book.entity.BookEntity;
import lombok.Builder;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.awt.print.Book;
import java.time.LocalDateTime;

@Getter
@Builder
public class BookResDto {
    private Long id;
    private String title;
    private Integer price;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static BookResDto from(BookEntity entity){
        return BookResDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .price(entity.getPrice())
                .createdAt(entity.getCreatedAt())
                .modifiedAt(entity.getModifiedAt())
                .build();
    }
}
