package com.kh.app.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeApiController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/admin")
    public String admin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());
        return "admin~";
    }

    @GetMapping("/user")
    public String user(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());
        return "user~~";
    }
}
