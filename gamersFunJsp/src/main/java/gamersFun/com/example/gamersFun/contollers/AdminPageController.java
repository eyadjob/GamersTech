package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.entity.CategoryEntity;
import gamersFun.com.example.gamersFun.entity.NewsPageEntity;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.enums.UserRole;
import gamersFun.com.example.gamersFun.repository.CategoryDao;
import gamersFun.com.example.gamersFun.repository.NewsPageDao;
import gamersFun.com.example.gamersFun.repository.UserDao;
import gamersFun.com.example.gamersFun.service.AdminService;
import gamersFun.com.example.gamersFun.service.CategoryService;
import gamersFun.com.example.gamersFun.service.UserService;
import gamersFun.com.example.gamersFun.utility.CollectionsConverter;
import gamersFun.com.example.gamersFun.utility.PropManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminPageController {

    @Autowired
    NewsPageDao newsPageDao;

    @Autowired
    AdminService adminService;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    RegistrationContoller registrationContoller;

    @RequestMapping("/adminConsole")
    ModelAndView getAdminConsole(ModelAndView modelAndView, @ModelAttribute(value = "categoryEntity") @Valid CategoryEntity categoryEntity, @ModelAttribute(value = "newsPageId") @Valid NewsPageEntity newsPageId, @RequestParam(name = "message", required = false) String message) {
        Iterable<CategoryEntity> categoryEntities = categoryDao.findAll();
        Pageable newsPageEntityFirstPage = PageRequest.of(0, 1);
        Iterable<NewsPageEntity> newsPageEntities = newsPageDao.findAll();
        Iterable<UserEntity> userEntities = userDao.findAll();

        List<CategoryEntity> categoryEntityList = CollectionsConverter.getListFromIterator(categoryEntities);
        modelAndView.setViewName("app.admin-console");
        modelAndView.getModel().put("allCategories", categoryEntityList);
        modelAndView.getModel().put("allNewsPages", newsPageEntities);
        modelAndView.getModel().put("allUsers", userEntities);
        modelAndView.getModel().put("allRoles", UserRole.getRoleNamesWithExcludeValue("admin"));
        modelAndView.getModel().put("newsPageEntity", new NewsPageEntity());
        modelAndView.getModel().put("categoryEntity", new CategoryEntity());
        modelAndView.getModel().put("messages", adminService.populateAdminModelViewMessages(modelAndView));
        if ( message !=  null) {
            Map<String,String> mapNewValue = new HashMap<>() {{put(message.split(",")[0],message.split(",")[1]);}};
            modelAndView.addObject("messages",adminService.populateAdminModelViewMessages(modelAndView,mapNewValue));
            modelAndView.getModel().put(message.split(",")[0],message.split(",")[1]);
        }
        modelAndView.getModel().put("userEntity", new UserEntity());
        return modelAndView;
    }

    @RequestMapping("/deleteCategory{categoryId}")
    String deleteCategory(@RequestParam("categoryId") String categoryId) {
        categoryDao.deleteById(Long.parseLong(categoryId));
        return "/adminConsole";
    }

    @PostMapping("/addCategory")
    String addCategory(@RequestParam("name") String categoryName) {
        categoryDao.save(new CategoryEntity(categoryName));
        return "/adminConsole?message=categoryAdditionSuccessStatus,true";
    }

    @PostMapping("/editCategory")
    String updatedCategory(CategoryEntity categoryEntity) {
        categoryService.updateCategoryName(categoryEntity);
        return "/adminConsole";
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

    @PostMapping("/addNewsPage")
    String addCategory(@RequestParam("newsImageFile") String newsImageFile, @ModelAttribute("newsPageEntity") @Valid NewsPageEntity newsPageEntity) {
        newsPageDao.save(new NewsPageEntity());
        return "/adminConsole";
    }


    @RequestMapping("/enableUser")
    String enableUser(@RequestParam("userId") String userId, @RequestParam("userEnabled") boolean enableUser) {
        userService.enableUser(Long.parseLong(userId), enableUser);
        return "/adminConsole";
    }

    @PostMapping("/updateUser")
    String updatedCategory(UserEntity userEntity) {
        userService.updateUser(userEntity);
        return "/adminConsole";
    }

    @PostMapping("/addUser")
    String addNewUser(UserEntity userEntity) {
        userService.save(userEntity);
        return "/adminConsole";
    }


}
