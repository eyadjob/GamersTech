package gamersFun.com.example.gamersFun.action.implementation;

import gamersFun.com.example.gamersFun.action.IAction;
import gamersFun.com.example.gamersFun.configuration.WebSecurityConfig;
import gamersFun.com.example.gamersFun.entity.Blogs;
import gamersFun.com.example.gamersFun.entity.Profile;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.service.BlogsService;
import gamersFun.com.example.gamersFun.service.ProfileService;
import gamersFun.com.example.gamersFun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class EditBlogAttributes implements IAction {

    private UserService userService;


    private ProfileService profileService;

    private SecurityContextHolderAwareRequestWrapper requestWrapper;

    private BlogsService blogsService;

    @Override
    public void populateActionAttributes(HttpServletRequest request, ModelAndView modelAndView) {
        UserEntity user = ((UserService)request.getAttribute("userService")).getUser();
        Profile profile = ((ProfileService)request.getAttribute("profileService")).getUserProfile(user);
        blogsService = (BlogsService) request.getAttribute("blogService");
        requestWrapper = (SecurityContextHolderAwareRequestWrapper)request.getAttribute("requestWrapper");
        if(requestWrapper.isUserInRole(WebSecurityConfig.BLOGGER_ROLE)){
            String page  =  request.getParameter("p");
            int currentPage = 1;
            if(page != null){
                currentPage = Integer.parseInt(page);
            }
            Page<Blogs> blogsPage =  blogsService.findAllByProfile(profile,currentPage);
            modelAndView.getModel().put("blogs",blogsPage);
        }

        modelAndView.getModel().put("blog",blogsService.findById(Long.valueOf(request.getParameter("id"))));
        modelAndView.getModel().put("tab","edit-blog");
    }
}
