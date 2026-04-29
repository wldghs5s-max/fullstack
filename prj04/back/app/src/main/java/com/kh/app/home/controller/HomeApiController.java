package com.kh.app.home.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class HomeApiController {
    @GetMapping("/home")
    public String home(){
        return "HOME~~~~";
    }
    @GetMapping("/test")
    public String test(){
        return "TEST~~~";
    }
}
