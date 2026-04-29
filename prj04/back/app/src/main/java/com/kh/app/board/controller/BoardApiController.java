package com.kh.app.board.controller;

import com.kh.app.board.dto.request.BoardCreateReqDto;
import com.kh.app.board.dto.request.BoardSearchCondition;
import com.kh.app.board.dto.response.BoardRespDto;
import com.kh.app.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping("/user/board")
    public ResponseEntity<Void> create(@RequestBody BoardCreateReqDto reqDto){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        boardService.create(reqDto,username);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/public/board")
    public ResponseEntity<Page<BoardRespDto>> getList(BoardSearchCondition condition, @RequestParam(defaultValue = "1") int pno){
        pno -= 1;
        Page<BoardRespDto> dtoList = boardService.getList(condition,pno);
        return ResponseEntity.ok(dtoList);
    }
    @GetMapping("/public/board/{id}")
    public ResponseEntity<BoardRespDto> getOne(@PathVariable Long id){
        BoardRespDto respDto = boardService.getOne(id);
        return ResponseEntity.ok(respDto);
    }

    @DeleteMapping("/user/board/{id}")
    public ResponseEntity<Object> remove(@PathVariable Long id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boardService.remove(id,username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/user/board/{id}")
    public ResponseEntity<BoardRespDto> update(@PathVariable Long id, @RequestBody BoardCreateReqDto reqDto){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        BoardRespDto respDto = boardService.update(id, reqDto, username);
        return ResponseEntity.ok(respDto);
    }





}
