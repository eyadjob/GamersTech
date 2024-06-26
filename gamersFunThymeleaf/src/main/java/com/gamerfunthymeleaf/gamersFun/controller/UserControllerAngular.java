package com.gamerfunthymeleaf.gamersFun.controller;

import com.gamerfunthymeleaf.gamersFun.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserControllerAngular {
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void registerUser(@RequestBody User user) {
    }

    @GetMapping("/{id}")
    public User getUser() {
        return new User();
    }

}
