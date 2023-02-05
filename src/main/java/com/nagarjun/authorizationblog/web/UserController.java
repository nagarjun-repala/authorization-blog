package com.nagarjun.authorizationblog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nagarjun.authorizationblog.entity.User;
import com.nagarjun.authorizationblog.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
  
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> createUser(@RequestBody User user) {

        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

