package com.gamerfunthymeleaf.gamersFun.controller;


import com.gamerfunthymeleaf.gamersFun.entity.User;
import com.gamerfunthymeleaf.gamersFun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationContoller {

    @Autowired
    private UserService userService;

//    @RequestMapping(value="/signup",method = RequestMethod.GET)
    @RequestMapping("/signup")
    String register(Model model){
        User siteUser = new User();
//        modelAndView.setViewName("/gamersfun/html/signup.html");
//        modelAndView.getModel().put("user",siteUser);
        return "/gamersfun/html/signup";
    }

     @RequestMapping(value = "/signup", method = RequestMethod.POST)
     String postRegister(ModelAndView modelAndView, @ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult){
        modelAndView.setViewName("/gamersfun/html/signup.html");
        if(!bindingResult.hasErrors()){

            UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
            if(userDetails != null){
                bindingResult.addError(new ObjectError("email","Email already used ."));
                return "redirect:/gamersfun/html/signup";
            }
            userService.register(user);
            modelAndView.setViewName("/gamersfun/html/verifyEmail");
        }
        return "redirect:/gamersfun/html/verifyEmail";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute User userInfo) {
        userService.register(userInfo);
        return "redirect:/users/";
    }

}
