package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.entity.TokenType;
import gamersFun.com.example.gamersFun.entity.User;
import gamersFun.com.example.gamersFun.entity.VerificationToken;
import gamersFun.com.example.gamersFun.service.EmailService;
import gamersFun.com.example.gamersFun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class RegistrationContoller {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Value("${message.registration.confirmed}")
    private String registrationConfirmMessage;

    @RequestMapping(value="/signup",method = RequestMethod.GET)
    ModelAndView register(ModelAndView modelAndView){
        User siteUser = new User();
        modelAndView.setViewName("app.signup");
        modelAndView.getModel().put("user",siteUser);
        return modelAndView;
    }

    @RequestMapping(value="/signup",method = RequestMethod.POST)
    ModelAndView postRegister(ModelAndView modelAndView, @ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult){
        modelAndView.setViewName("app.signup");
        if(!bindingResult.hasErrors()){

            UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
            if(userDetails != null){
                bindingResult.addError(new ObjectError("email","Email already used."));
                return modelAndView;
            }
            userService.register(user);
            String token = userService.createVerificationToken(user, TokenType.REGISTRATION);
            emailService.sendVerificationEmail(user.getUserName(),user.getEmail(),token,"");
            modelAndView.setViewName("redirect:/verifyEmail");
        }

        return modelAndView;
    }

    @RequestMapping("/verifyEmail")
    String verifyEmail(){
        return "app.verifyEmail";
    }

    @RequestMapping(value = "/confirmRegister",method = RequestMethod.GET)
    ModelAndView configrmRegistration(ModelAndView modelAndView, @RequestParam("t") String token){
        VerificationToken verificationToken = userService.getVerification(token);
        if(null == verificationToken){
            modelAndView.setViewName("redirect:/invalidUser");
            return modelAndView;
        }

        Date exireDate = verificationToken.getExpire();
        if(exireDate.before(new Date())){
            userService.deleteToken(verificationToken);
            modelAndView.setViewName("redirect:/expiredToken");
            return modelAndView;
        }

        User user = verificationToken.getUser();
        if(user == null){
            userService.deleteToken(verificationToken);
            modelAndView.setViewName("redirect:/invalidUser");
            return modelAndView;
        }

        userService.deleteToken(verificationToken);
        user.setEnabled(Boolean.TRUE);
        userService.save(user);
        modelAndView.getModel().put("message",registrationConfirmMessage);
        modelAndView.setViewName("app.message");

        return modelAndView;


    }


}