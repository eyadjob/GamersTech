package gamersFun.com.example.gamersFun.service;

import gamersFun.com.example.gamersFun.utility.PropManager;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Service
public class AdminService {


    public ModelAndView populateAdminModelViewMessages(ModelAndView modelAndView, Map<String,String> newValuesMap) {
        modelAndView.getModel().put("categoryAdditionSuccessMessage","Category Added Successfully ...");
        ModelMap modelMap = new ModelMap();
        modelMap.putAll(PropManager.getInstance().getPropertiesAsStringMap());
        modelMap.putAll(newValuesMap);
        return modelAndView;
    }

    public ModelAndView populateAdminModelViewMessages(ModelAndView modelAndView) {
        modelAndView.getModel().put("categoryAdditionSuccessMessage","Category Added Successfully ...");
        modelAndView.getModel().put("categoryAdditionSuccessStatus","false");
        ModelMap modelMap = new ModelMap();
        modelMap.putAll(PropManager.getInstance().getPropertiesAsStringMap());
        return modelAndView;
    }
}
