package com.gamerfunthymeleaf.gamersFun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PagesController {

	@Value("${spring.application.name}")
	String appName;

	@RequestMapping("/getHome")
	public String homePage() {

		return "/gamersfun/html/home-2.html";
	}
	@RequestMapping("/about")
	String about(){
		return "/gamersfun/html/about.html";
	}

	@RequestMapping(path = "/eyad", method = RequestMethod.GET)
	public String eyad(){
		return "eyad string";
	}

	@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	public String helloWorld(){
		return "Hello World";
	}


	@RequestMapping("/author")
	String author(){
		return "app.author";
	}

	@RequestMapping("/search")
	String search(){
		return "app.search";
	}


	@RequestMapping("/contactUs")
	String contactUs(){
		return "app.contactUs";
	}

	@RequestMapping("/err")
	String errr(){
		if(true){
			throw new RuntimeException("Error ");
		}

		return "app.contactUs";
	}


}
