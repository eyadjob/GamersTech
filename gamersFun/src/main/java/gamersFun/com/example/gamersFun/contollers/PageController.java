package gamersFun.com.example.gamersFun.contollers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {



    @RequestMapping("/")
    ModelAndView home(ModelAndView modelAndView){
        modelAndView.setViewName("app.homepage");
        modelAndView.getModel().put("statusUpdate","");
        return modelAndView;
    }

    @RequestMapping("/about")
    String about(){
        return "app.about";
    }

    @RequestMapping("/eyad")
    String eyadTest(){
        return "eyad test";
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
