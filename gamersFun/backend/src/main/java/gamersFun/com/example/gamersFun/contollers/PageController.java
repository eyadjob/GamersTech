package gamersFun.com.example.gamersFun.contollers;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
