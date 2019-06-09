package com.scut.onlinebookstore.controller;

import com.scut.onlinebookstore.controller.PersonControllers.VisitorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {
    @RequestMapping("hello")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("user")
    public String user(){
        return new VisitorController();
    }
}
