package com.scut.onlinebookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {
    @RequestMapping
    public String home() {
        return "Hello World!";
    }
}
