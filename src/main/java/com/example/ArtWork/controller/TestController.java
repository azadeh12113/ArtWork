package com.example.ArtWork.controller;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Server is running!";
    }
}
