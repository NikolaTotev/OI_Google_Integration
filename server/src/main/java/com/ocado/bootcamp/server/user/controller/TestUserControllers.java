package com.ocado.bootcamp.server.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class TestUserControllers {

    @GetMapping("/user")
    public ResponseEntity<String> testUser(){
        return new ResponseEntity<>( "{ooga:booga}", HttpStatus.OK);
    }
}
