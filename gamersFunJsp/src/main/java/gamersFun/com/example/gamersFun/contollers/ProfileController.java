package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.configuration.WebSecurityConfig;
import gamersFun.com.example.gamersFun.entity.Blogs;
import gamersFun.com.example.gamersFun.entity.Profile;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.service.BlogsService;
import gamersFun.com.example.gamersFun.service.ProfileService;
import gamersFun.com.example.gamersFun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private BlogsService blogsService;


    private String photoUploadDirectory;

    public ProfileController(){
        this.photoUploadDirectory = System.getProperty("user.dir");
    }

    @RequestMapping("/profile")
    ModelAndView showProfilePage(SecurityContextHolderAwareRequestWrapper requestWrapper) {
        UserEntity UserEntity = userService.getUser();
        ModelAndView modelAndView = showProfile(UserEntity);
        if(requestWrapper.isUserInRole(WebSecurityConfig.BLOGGER_ROLE)){
            Profile profile = profileService.getUserProfile(UserEntity);
            modelAndView.getModel().put("blogs",profile.getBlogs());
        }

        return modelAndView;
    }

    private ModelAndView showProfile(UserEntity UserEntity) {
        ModelAndView view = new ModelAndView();
        if (UserEntity == null) {
            view.setViewName("redirect:/");
            return view;
        }

        Profile profileDb = profileService.getUserProfile(UserEntity);
        if (profileDb == null) {
            Profile profile = new Profile();
            profile.setUser(UserEntity);
            profileDb = profileService.save(profile);
        }

        Profile readOnlyProfile = new Profile();
        readOnlyProfile.safeCopyFrom(profileDb);

        view.setViewName("app.profile");
        view.getModel().put("profile", readOnlyProfile);
        view.getModel().put("email", UserEntity.getEmail());
        view.getModel().put("userId", UserEntity.getId());
        view.getModel().put("blog", new Blogs());
        return view;
    }


}
