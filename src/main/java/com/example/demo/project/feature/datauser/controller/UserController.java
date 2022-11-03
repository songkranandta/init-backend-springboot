package com.example.demo.project.feature.datauser.controller;

import com.example.demo.project.feature.datauser.model.UserModel;
import com.example.demo.project.feature.datauser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/data-user")
    public ResponseEntity<UserModel.Response> user() {
        return ResponseEntity.ok(userService.getUser());
    }

    @PostMapping("/add-user")
    public ResponseEntity<UserModel.Response> addUser(@RequestBody UserModel.Request request){
        return ResponseEntity.ok(userService.addUser(request));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserModel.Response>> allUser(){
        return ResponseEntity.ok(userService.getAll());
    }


    @PostMapping("/cal-gpa")
    public ResponseEntity<List<UserModel.Student>> calGpa(@RequestBody List<UserModel.Student> data){
        return  ResponseEntity.ok(data);
    }
}
