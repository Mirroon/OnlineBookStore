package com.scut.onlinebookstore.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
    @PostMapping(value = "hello")
    String home() {
        return "Hello World!";
    }
}
