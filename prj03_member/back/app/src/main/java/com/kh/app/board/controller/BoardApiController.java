package com.kh.app.board.controller;

import com.kh.app.board.dto.request.BoardCreateReqDto;
import com.kh.app.board.dto.request.BoardSearchCondition;
import com.kh.app.board.dto.response.BoardRespDto;
import com.kh.app.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody BoardCreateReqDto dto){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boardService.insert(dto,username);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<BoardRespDto> seletList(){
        log.info("[seletList] ~~~~~");
        return boardService.seletList();
    }

    @GetMapping("/search")
    public List<BoardRespDto> search(BoardSearchCondition condition){
        return boardService.search(condition);
    }



    @GetMapping("{id}")
    public BoardRespDto selectOne(@PathVariable Long id){
        return boardService.selectOne(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boardService.delete(id,username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<BoardRespDto> update(@RequestBody BoardCreateReqDto dto, @PathVariable Long id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        BoardRespDto respDto = boardService.update(dto,id,username);
        return ResponseEntity.status(HttpStatus.OK)
                .body(respDto);
    }

}
