package gamersFun.com.example.gamersFun.action;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface IAction {
    public void populateActionAttributes(HttpServletRequest request, ModelAndView modelAndView);
}
