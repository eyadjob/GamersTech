package com.gamerfunthymeleaf.gamersFun.controller;


import com.gamerfunthymeleaf.gamersFun.entity.User;
import com.gamerfunthymeleaf.gamersFun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationContoller {

    @Autowired
    private UserService userService;

//    @RequestMapping(value="/signup",method = RequestMethod.GET)
    @RequestMapping("/signup")
    String register(ModelAndView modelAndView){
//        User siteUser = new User();
//        modelAndView.setViewName("/gamersfun/html/signup.html");
//        modelAndView.getModel().put("user",siteUser);
        return "/gamersfun/html/signup.html";
    }

//    @RequestMapping(value="/signup",method = RequestMethod.POST)
    @RequestMapping(path = "/signup", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    String postRegister(ModelAndView modelAndView, @ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult){
        modelAndView.setViewName("/gamersfun/html/signup.html");
        if(!bindingResult.hasErrors()){

            UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
            if(userDetails != null){
                bindingResult.addError(new ObjectError("email","Email already used ."));
                return "/gamersfun/html/signup.html";
            }
            userService.register(user);


            modelAndView.setViewName("/gamersfun/html/verifyEmail.html");
        }

        return "/gamersfun/html/signup.html";
    }


}
