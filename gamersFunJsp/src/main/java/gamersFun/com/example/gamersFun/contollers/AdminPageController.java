package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.entity.CategoryEntity;
import gamersFun.com.example.gamersFun.entity.NewsPageEntity;
import gamersFun.com.example.gamersFun.repository.CategoryDao;
import gamersFun.com.example.gamersFun.repository.NewsPageDao;
import gamersFun.com.example.gamersFun.service.CategoryService;
import gamersFun.com.example.gamersFun.utility.CollectionsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminPageController {

    @Autowired
    NewsPageDao newsPageDao;
    @Autowired
    CategoryDao categoryDao;

    @Autowired
    CategoryService categoryService;


    @RequestMapping("/adminConsole")
    ModelAndView getAdminConsole(ModelAndView modelAndView, @ModelAttribute(value = "categoryEntity") @Valid CategoryEntity categoryEntity,@ModelAttribute(value = "newsPageId") @Valid NewsPageEntity newsPageId) {
        Iterable<CategoryEntity> categoryEntities = categoryDao.findAll();
        Iterable<NewsPageEntity> newsPageEntities = newsPageDao.findAll();
        List<CategoryEntity> categoryEntityList = CollectionsConverter.getListFromIterator(categoryEntities);
        modelAndView.setViewName("app.admin-console");
        modelAndView.getModel().put("allCategories", categoryEntityList);
        modelAndView.getModel().put("allNewsPages", newsPageEntities);
        return modelAndView;
    }

    @RequestMapping("/deleteCategory{categoryId}")
    String deleteCategory(ModelAndView modelAndView, @RequestParam("categoryId") String categoryId) {
        categoryDao.deleteById(Long.parseLong(categoryId));
        return "/adminConsole";
    }

    @PostMapping("/addCategory")
    String addCategory( @RequestParam("name") String categoryName) {
        categoryDao.save(new CategoryEntity(categoryName));
        return "/adminConsole";
    }

    @PostMapping("/editCategory")
    ModelAndView updatedCategory(ModelAndView modelAndView, @RequestParam("updatedCategoryName") String categoryName,@RequestParam("categoryId") String categoryId) {
        categoryService.updateCategoryName(new CategoryEntity(Long.parseLong(categoryId), categoryName));
        modelAndView.setViewName("app.admin-console");
        modelAndView.getModel().put("allCategories", getCategoryList());
        modelAndView.getModel().put("categoryEntity", new CategoryEntity());
        return modelAndView;
    }

    public List<CategoryEntity> getCategoryList() {
        return CollectionsConverter.getListFromIterator(categoryDao.findAll());
    }

//    @RequestMapping("/deleteNewsPage{newsPageId}")
//    ModelAndView deleletNewsPage(ModelAndView modelAndView, @RequestParam("newsPageId") String newsPageId) {
//        newsPageDao.deleteById(Long.parseLong(newsPageId));
//        modelAndView.setViewName("app.admin-console");
//        modelAndView.getModel().put("allCategories", getCategoryList());
//        return modelAndView;
//    }

    @RequestMapping("/getShopPage")
    ModelAndView getShopPage(ModelAndView modelAndView) {
        modelAndView.setViewName("app.shop-account");
        return modelAndView;
    }

}
