package com.kh.app.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/home")
public class HomeApiController {
    @GetMapping
    public String home(){
        return "test";
    }
}
