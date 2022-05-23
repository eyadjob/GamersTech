package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.entity.CategoryEntity;
import gamersFun.com.example.gamersFun.entity.NewsPageEntity;
import gamersFun.com.example.gamersFun.repository.CategoryDao;
import gamersFun.com.example.gamersFun.repository.NewsPageDao;
import gamersFun.com.example.gamersFun.utility.CollectionsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import java.util.List;

@Controller
public class AdminPageController {

    @Autowired
    NewsPageDao newsPageDao;
    @Autowired
    CategoryDao categoryDao;

    @RequestMapping("/adminConsole")
    ModelAndView getAdminConsole(ModelMap modelMap, ModelAndView modelAndView, @ModelAttribute(value = "newsPage") @Valid NewsPageEntity newsPage, BindingResult bindingResult) {
        Iterable<CategoryEntity> categoryEntities = categoryDao.findAll();
        List<CategoryEntity> categoryEntityList = CollectionsConverter.getListFromIterator(categoryEntities);
        System.out.println(categoryEntityList.toString());
        modelMap.addAttribute("allCategories",categoryEntityList);
        modelAndView.setViewName("app.admin-console");
        modelAndView.getModel().put("allCategories", categoryEntityList);
        return modelAndView;
    }

//    @RequestMapping("//deleteCategory?categoryId=${categoriesVar.getId()}   ")
//    ModelAndView getAdminConsole(ModelMap modelMap, ModelAndView modelAndView, @ModelAttribute(value = "newsPage") @Valid NewsPageEntity newsPage, BindingResult bindingResult) {
//        Iterable<CategoryEntity> categoryEntities = categoryDao.findAll();
//        List<CategoryEntity> categoryEntityList = CollectionsConverter.getListFromIterator(categoryEntities);
//        System.out.println(categoryEntityList.toString());
//        modelMap.addAttribute("allCategories",categoryEntityList);
//        modelAndView.setViewName("app.admin-console");
//        modelAndView.getModel().put("allCategories", categoryEntityList);
//        return modelAndView;
//    }


}
