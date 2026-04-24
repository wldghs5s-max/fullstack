package com.kh.app.notice.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notice")
public class NoticeApiController {

    @GetMapping("insert")
    public void insert(){
        System.out.println("NoticeApiController.insert !!!!!!!!!!!!!!!!!!!!!!!@@@@@@@@@@");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("username = " + username);
    }
}
