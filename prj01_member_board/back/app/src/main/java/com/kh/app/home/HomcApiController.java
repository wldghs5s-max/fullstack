package com.kh.app.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/home")
public class HomcApiController {
    @GetMapping
    public String m01(){
        return "testtt";
    }
}
