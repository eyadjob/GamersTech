package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.entity.Blogs;
import gamersFun.com.example.gamersFun.entity.Profile;
import gamersFun.com.example.gamersFun.entity.User;
import gamersFun.com.example.gamersFun.service.ProfileService;
import gamersFun.com.example.gamersFun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @RequestMapping("/profile")
    ModelAndView showProfilePage(){
        User user = userService.getUser();
        ModelAndView modelAndView = showProfile(user);
        return modelAndView;
    }

    private ModelAndView showProfile(User user){
        ModelAndView view = new ModelAndView();
        if(user == null){
            view.setViewName("redirect:/");
            return view;
        }

        Profile profileDb = profileService.getUserProfile(user);
        if(profileDb == null){
            Profile profile = new Profile();
            profile.setUser(user);
            profileDb =  profileService.save(profile);
        }

        Profile readOnlyProfile = new Profile();
        readOnlyProfile.safeCopyFrom(profileDb);

        view.setViewName("app.profile");
        view.getModel().put("profile",readOnlyProfile);
        view.getModel().put("email",user.getEmail());
        view.getModel().put("userId",user.getId());
        view.getModel().put("blog",new Blogs());
        return view;
    }



}
