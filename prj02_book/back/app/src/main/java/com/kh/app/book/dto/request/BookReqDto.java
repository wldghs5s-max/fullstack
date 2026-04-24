package com.kh.app.book.dto.request;

import com.kh.app.book.dto.response.BookResDto;
import com.kh.app.book.entity.BookEntity;
import lombok.Getter;

@Getter
public class BookReqDto {
    private String title;
    private Integer price;



    public BookEntity toEntity(){
        return BookEntity.builder()
                .title(title)
                .price(price)
                .build();
    }
}
