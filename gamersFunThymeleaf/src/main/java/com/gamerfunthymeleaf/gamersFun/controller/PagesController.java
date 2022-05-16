package com.gamerfunthymeleaf.gamersFun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class PagesController {

	@Value("${spring.application.name}")
	String appName;


	@RequestMapping("/getHome")
	public String homePage(Model model) {
//		model.addAttribute("appName", appName);
		return "/gamersfun/html/home-2.html";
	}

}
