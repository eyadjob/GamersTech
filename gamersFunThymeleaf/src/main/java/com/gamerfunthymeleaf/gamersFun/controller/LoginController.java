package com.gamerfunthymeleaf.gamersFun.controller;

import com.gamerfunthymeleaf.gamersFun.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private BikeService bikeService;



}
