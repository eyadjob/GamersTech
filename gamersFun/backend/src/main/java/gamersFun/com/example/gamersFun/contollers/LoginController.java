package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.entity.Bike;
import gamersFun.com.example.gamersFun.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private BikeService bikeService;


    @RequestMapping("/login")
    String admin(){
        return "" +
                "" +
                "app.login";
    }



}
