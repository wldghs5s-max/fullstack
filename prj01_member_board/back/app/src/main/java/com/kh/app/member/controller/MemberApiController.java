package com.kh.app.member.controller;

import com.kh.app.member.dto.request.MemberJoinReqDto;
import com.kh.app.member.dto.response.MemberResDto;
import com.kh.app.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
@Slf4j
public class MemberApiController {
    private final MemberService memberService;
    @PostMapping
    public ResponseEntity<Void> join(@RequestBody MemberJoinReqDto reqDto){
        log.info("Join Request : {}",reqDto);
        memberService.join(reqDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<MemberResDto> findById(@PathVariable Long id){
        log.info("Select Request : {}",id);
        MemberResDto dto = memberService.findById(id);
        return ResponseEntity.ok(dto);
    }
}
