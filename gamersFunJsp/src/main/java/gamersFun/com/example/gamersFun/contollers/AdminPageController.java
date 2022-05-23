package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.entity.CategoryEntity;
import gamersFun.com.example.gamersFun.entity.NewsPageEntity;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.repository.CategoryDao;
import gamersFun.com.example.gamersFun.repository.NewsPageDao;
import gamersFun.com.example.gamersFun.utility.CollectionsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
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
    ModelAndView getAdminConsole(ModelAndView modelAndView, @ModelAttribute(value = "categoryEntity") @Valid CategoryEntity categoryEntity) {
        Iterable<CategoryEntity> categoryEntities = categoryDao.findAll();
        List<CategoryEntity> categoryEntityList = CollectionsConverter.getListFromIterator(categoryEntities);
        modelAndView.setViewName("app.admin-console");
        modelAndView.getModel().put("allCategories", categoryEntityList);
        return modelAndView;
    }

    @RequestMapping("/deleteCategory{categoryId}")
    ModelAndView deleteCategory(ModelAndView modelAndView, @RequestParam("categoryId") String categoryId) {
        categoryDao.deleteById(Long.parseLong(categoryId));
        modelAndView.setViewName("app.admin-console");
        modelAndView.getModel().put("allCategories", getCategoryList());
        modelAndView.getModel().put("categoryEntity", new CategoryEntity());
        return modelAndView;
    }


    @PostMapping("/addCategory")
    ModelAndView addCategory(ModelAndView modelAndView, @RequestParam("name") String categoryName) {
        categoryDao.save(new CategoryEntity(categoryName));
        modelAndView.setViewName("app.admin-console");
        modelAndView.getModel().put("allCategories", getCategoryList());
        modelAndView.getModel().put("categoryEntity", new CategoryEntity());
        return modelAndView;
    }

    public List<CategoryEntity> getCategoryList() {
        return  CollectionsConverter.getListFromIterator(categoryDao.findAll());
    }


}
