package gamersFun.com.example.gamersFun.action.implementation;

import gamersFun.com.example.gamersFun.action.IAction;
import gamersFun.com.example.gamersFun.entity.Blogs;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class AddBlogAttributes implements IAction {
    @Override
    public void populateActionAttributes(HttpServletRequest request, ModelAndView modelAndView) {
        modelAndView.getModel().put("error", request.getParameter("error"));
        modelAndView.getModel().put("tab", request.getParameter("tab"));
        modelAndView.getModel().put("p", request.getParameter("p"));
        modelAndView.getModel().put("blog", new Blogs());
        modelAndView.getModel().put("message", request.getParameter("message"));
        Blogs blogs = (Blogs) request.getSession().getAttribute("blogs");
        request.getSession().removeAttribute("blogs");
        if(blogs != null){
            modelAndView.getModel().put("blog", blogs);
        }else {
            modelAndView.getModel().put("blog", new Blogs());
        }
    }
}
