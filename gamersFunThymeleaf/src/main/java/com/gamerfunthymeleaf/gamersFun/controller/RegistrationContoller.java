package com.gamerfunthymeleaf.gamersFun.controller;


import com.gamerfunthymeleaf.gamersFun.entity.User;
import com.gamerfunthymeleaf.gamersFun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value="/signup",method = RequestMethod.GET)
    ModelAndView register(ModelAndView modelAndView){
        User siteUser = new User();
        modelAndView.setViewName("app.signup");
        modelAndView.getModel().put("user",siteUser);
        return modelAndView;
    }

    @RequestMapping(value="/signup",method = RequestMethod.POST)
    ModelAndView postRegister(ModelAndView modelAndView, @ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult){
        modelAndView.setViewName("app.register");
        if(!bindingResult.hasErrors()){

            UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
            if(userDetails != null){
                bindingResult.addError(new ObjectError("email","Email already used ."));
                return modelAndView;
            }
            userService.register(user);


            modelAndView.setViewName("redirect:/verifyEmail");
        }

        return modelAndView;
    }


}
