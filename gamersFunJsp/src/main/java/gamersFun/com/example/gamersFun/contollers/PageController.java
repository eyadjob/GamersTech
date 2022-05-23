package gamersFun.com.example.gamersFun.contollers;


import gamersFun.com.example.gamersFun.entity.CategoryEntity;
import gamersFun.com.example.gamersFun.entity.NewsPageEntity;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PageController {

    @RequestMapping("/")
    ModelAndView home(ModelAndView modelAndView) {
        modelAndView.setViewName("app.homepage");
        modelAndView.getModel().put("statusUpdate", "");
        return modelAndView;
    }

    @RequestMapping("/about")
    String about() {
        return "app.about";
    }

    @RequestMapping("/author")
    String author() {
        return "app.author";
    }

    @RequestMapping("/search")
    String search() {
        return "app.search";
    }


    @RequestMapping("/contactUs")
    String contactUs() {
        return "app.contactUs";
    }

    @RequestMapping("/err")
    String errr() {
        if (true) {
            throw new RuntimeException("Error ");
        }

        return "app.contactUs";
    }


    @RequestMapping("/shopAccount")
    String getShopAccountPage() {
        return "app.shop-account";
    }
}
