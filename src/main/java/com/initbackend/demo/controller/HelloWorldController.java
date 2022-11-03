package com.initbackend.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HelloWorldController
{
    @GetMapping("/hello")
    public String hello()
    {
        return "Hello World";
    }
}