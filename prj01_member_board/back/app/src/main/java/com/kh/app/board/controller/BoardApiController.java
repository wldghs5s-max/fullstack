package com.kh.app.board.controller;

import com.kh.app.board.dto.request.BoardCreateReqDto;
import com.kh.app.board.dto.response.BoardResDto;
import com.kh.app.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board")
@Slf4j
@CrossOrigin
public class BoardApiController {
    private final BoardService boardService;
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody BoardCreateReqDto reqDto){
        log.info("Board Create : {}" ,reqDto);
        boardService.save(reqDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("{id}")
    public ResponseEntity<BoardResDto> findById(@PathVariable Long id){
        log.info("Board Select : {}",id);
        BoardResDto resDto = boardService.findById(id);
        return ResponseEntity.ok(resDto);

    }
    @GetMapping
    public ResponseEntity<List<BoardResDto>> findAll(){
        log.info("Board Select All");
        List<BoardResDto> resDtoList = boardService.findAll();
        return ResponseEntity.ok(resDtoList);
    }


}
