package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.entity.TokenTypeEntity;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.entity.VerificationTokenEntity;
import gamersFun.com.example.gamersFun.service.BlogsModule;
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
    private BlogsModule blogsModule;

    @Value("${message.registration.confirmed}")
    private String registrationConfirmMessage;

    @RequestMapping(value="/signup",method = RequestMethod.GET)
    ModelAndView register(ModelAndView modelAndView){
        UserEntity siteUserEntity = new UserEntity();
        modelAndView.setViewName("app.signup");
        modelAndView.getModel().put("user", siteUserEntity);
        return modelAndView;
    }

    @RequestMapping(value="/signup",method = RequestMethod.POST)
    ModelAndView signupNewUser(ModelAndView modelAndView, @ModelAttribute(value = "user") @Valid UserEntity userEntity, BindingResult bindingResult){
        modelAndView.setViewName("app.signup");
        if(!bindingResult.hasErrors()){

            UserDetails userDetails = blogsModule.getUserService().loadUserByUsername(userEntity.getEmail());
            if(userDetails != null){
                bindingResult.addError(new ObjectError("email","Email already used."));
                return modelAndView;
            }
            blogsModule.getUserService().register(userEntity);
            String token = blogsModule.getUserService().createVerificationToken(userEntity, TokenTypeEntity.REGISTRATION);
            blogsModule.getEmailService().sendVerificationEmail(userEntity.getUserName(), userEntity.getEmail(),token,"");
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
        VerificationTokenEntity verificationTokenEntity = blogsModule.getUserService().getVerification(token);
        if(null == verificationTokenEntity){
            modelAndView.setViewName("redirect:/invalidUser");
            return modelAndView;
        }

        Date exireDate = verificationTokenEntity.getExpire();
        if(exireDate.before(new Date())){
            blogsModule.getUserService().deleteToken(verificationTokenEntity);
            modelAndView.setViewName("redirect:/expiredToken");
            return modelAndView;
        }

        UserEntity userEntity = verificationTokenEntity.getUser();
        if(userEntity == null){
            blogsModule.getUserService().deleteToken(verificationTokenEntity);
            modelAndView.setViewName("redirect:/invalidUser");
            return modelAndView;
        }

        blogsModule.getUserService().deleteToken(verificationTokenEntity);
        userEntity.setEnabled(Boolean.TRUE);
        blogsModule.getUserService().save(userEntity);
        modelAndView.getModel().put("message",registrationConfirmMessage);
        modelAndView.setViewName("app.message");

        return modelAndView;


    }


}
