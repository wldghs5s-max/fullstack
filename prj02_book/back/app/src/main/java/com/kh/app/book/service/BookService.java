package com.kh.app.book.service;

import com.kh.app.book.dto.request.BookReqDto;
import com.kh.app.book.dto.response.BookResDto;
import com.kh.app.book.entity.BookEntity;
import com.kh.app.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public void create(BookReqDto reqDto) {
        BookEntity entity = reqDto.toEntity();
        bookRepository.save(entity);
    }

    
    public List<BookResDto> findBookAll() {

        return bookRepository.findByDelYnOrderByIdDesc("N")
                .stream()
                .map(BookResDto::from)
                .toList();
    }

    public BookResDto findBookByid(Long id) {
        return BookResDto.from(bookRepository.findByIdAndDelYn(id,"N"));
    }
}
