package com.kh.app.book.contoller;

import com.kh.app.book.dto.request.BookReqDto;
import com.kh.app.book.dto.response.BookResDto;
import com.kh.app.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class BookApiController {
    private final BookService bookService;
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody BookReqDto reqDto){
        bookService.create(reqDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public List<BookResDto> findBookAll(){
        return bookService.findBookAll();
    }

    @GetMapping("{id}")
    public BookResDto findBookById(@PathVariable Long id){
        return bookService.findBookByid(id);
    }

















}
