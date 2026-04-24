package com.kh.app.member.controller;

import com.kh.app.member.dto.request.MemberJoinReqDto;
import com.kh.app.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<Void> join(@RequestBody MemberJoinReqDto dto){
        memberService.join(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

}
