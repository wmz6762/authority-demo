package com.example.authority.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String Index() {
        return "index后台返回的数据";
    }

    @PostMapping
    public String info() {
        return "info后台返回的数据";
    }

}
