package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.action.ActionAttributesFactory;
import gamersFun.com.example.gamersFun.action.IAction;
import gamersFun.com.example.gamersFun.configuration.WebSecurityConfig;
import gamersFun.com.example.gamersFun.entity.*;
import gamersFun.com.example.gamersFun.service.BlogsService;
import gamersFun.com.example.gamersFun.service.CategoryService;
import gamersFun.com.example.gamersFun.service.ProfileService;
import gamersFun.com.example.gamersFun.service.UserService;
import gamersFun.com.example.gamersFun.utility.CollectionsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private BlogsService blogsService;

    @Autowired
    private CategoryService categoryService;


    private String photoUploadDirectory;

    public ProfileController(){
        this.photoUploadDirectory = System.getProperty("user.dir");
    }

    @RequestMapping("/profile")
    ModelAndView showProfilePage(HttpServletRequest req, SecurityContextHolderAwareRequestWrapper requestWrapper,
                                 @RequestParam(value = "action", required = false) String action,
                                  RedirectAttributes redirectAttrs) {
        UserEntity UserEntity = userService.getUser();
        ModelAndView modelAndView = showProfile(UserEntity);
        populateActionAttributes(req, modelAndView);
        if(requestWrapper.isUserInRole(WebSecurityConfig.BLOGGER_ROLE)){
            Profile profile = profileService.getUserProfile(UserEntity);
            modelAndView.getModel().put("blogs",blogsService.findAllByProfile(profile));
        }

        return modelAndView;
    }

    private void populateActionAttributes(HttpServletRequest request, ModelAndView modelAndView) {
        IAction iAction = ActionAttributesFactory.getActionAttributes(request.getParameter("action"));
        if(iAction != null){
            iAction.populateActionAttributes(request,modelAndView);
        }
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
        List<CategoryEntity> categoryEntityList = CollectionsConverter.getListFromIterator( categoryService.findAll());
        view.getModel().put("blogs",blogsService.findAllByProfile(profileDb));
        view.getModel().put("blog", new Blogs());
        view.setViewName("app.profile");
        view.getModel().put("profile", readOnlyProfile);
        view.getModel().put("email", UserEntity.getEmail());
        view.getModel().put("userId", UserEntity.getId());
        view.getModel().put("allCategories", categoryEntityList);
        view.getModel().put("blog", new Blogs());
        view.getModel().put("ownProfile",true);
        return view;
    }


}
