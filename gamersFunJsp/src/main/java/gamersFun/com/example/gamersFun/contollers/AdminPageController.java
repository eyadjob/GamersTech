package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.entity.CategoryEntity;
import gamersFun.com.example.gamersFun.entity.FileInfo;
import gamersFun.com.example.gamersFun.entity.NewsPageEntity;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.enums.UserRole;
import gamersFun.com.example.gamersFun.repository.CategoryDao;
import gamersFun.com.example.gamersFun.repository.NewsPageDao;
import gamersFun.com.example.gamersFun.repository.UserDao;
import gamersFun.com.example.gamersFun.service.AdminService;
import gamersFun.com.example.gamersFun.service.CategoryService;
import gamersFun.com.example.gamersFun.service.FileService;
import gamersFun.com.example.gamersFun.service.UserService;
import gamersFun.com.example.gamersFun.utility.CollectionsConverter;
import gamersFun.com.example.gamersFun.utility.DateHelper;
import gamersFun.com.example.gamersFun.utility.RegxHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminPageController {

    final String newsPageImagesDirectory = "newsPageImages";
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
    @Autowired
    FileService fileService;

    @RequestMapping("/adminConsole")
    ModelAndView getAdminConsole(ModelAndView modelAndView, @ModelAttribute(value = "categoryEntity") @Valid CategoryEntity categoryEntity, @ModelAttribute(value = "newsPageId") @Valid NewsPageEntity newsPageId, @RequestParam(name = "message", required = false) String message) {
        Iterable<CategoryEntity> categoryEntities = categoryDao.findAll();
        Iterable<UserEntity> userEntities = userDao.findAll();
//        List<CategoryEntity> categoryEntityList = CollectionsConverter.getListFromIterator(categoryEntities);

        modelAndView.setViewName("app.admin-console");
        modelAndView.getModel().put("allCategories", categoryService.getListOfCategoriesWithRecordsSizeAndSorting2(0,10,"ascending"));
        modelAndView.getModel().put("allNewsPages", adminService.getListOfNewsPageWithRecordsSizeAndSorting2(0,3,"descending"));
        modelAndView.getModel().put("allUsers", userEntities);
        modelAndView.getModel().put("allRoles", UserRole.getRoleNamesWithExcludeValue("admin"));
        modelAndView.getModel().put("newsPageEntity", new NewsPageEntity());
        modelAndView.getModel().put("categoryEntity", new CategoryEntity());
        modelAndView.getModel().put("messages", adminService.populateAdminModelViewMessages(modelAndView));
        if (message != null) {
            Map<String, String> mapNewValue = new HashMap<>() {{
                put(message.split(",")[0], message.split(",")[1]);
            }};
            modelAndView.addObject("messages", adminService.populateAdminModelViewMessages(modelAndView, mapNewValue));
            modelAndView.getModel().put(message.split(",")[0], message.split(",")[1]);
        }
        modelAndView.getModel().put("userEntity", new UserEntity());
        return modelAndView;
    }

    @RequestMapping("/deleteCategory")
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

    @RequestMapping("/deleteNewsPage")
    String deleletNewsPage(ModelAndView modelAndView, @RequestParam("newsPageId") String newsPageId) {
        newsPageDao.deleteById(Long.parseLong(newsPageId));
        return "/adminConsole";
    }

    @RequestMapping("/getShopPage")
    ModelAndView getShopPage(ModelAndView modelAndView) {
        modelAndView.setViewName("app.shop-account");
        return modelAndView;
    }

    @PostMapping("/addNewsPage")
    String addCategory(@RequestParam("newsImageFile") MultipartFile newsImageFile, @ModelAttribute("newsPageEntity") @Valid NewsPageEntity newsPageEntity) {
        try {
            int currentPageId = Integer.parseInt(String.valueOf(((Object[]) newsPageDao.getLatestId())[4]))+1;
            String imageExtension =RegxHelper.getRegxMatch("[0-9a-z]+$", 0, newsImageFile.getOriginalFilename());
            String imageDirectory =new StringBuilder().append(System.getProperty("user.dir")).append("/").append(newsPageImagesDirectory).append("/").append(DateHelper.getCurrentDatePlusDays(0, "YYYY-MM-dd")).toString();
            String imageName = new StringBuilder().append(Calendar.getInstance().getTimeInMillis()).append("-").append(currentPageId).append(".").append(imageExtension).toString();
            FileInfo fileInfo = fileService.saveImageFileWithName(newsImageFile, imageDirectory,imageName,imageExtension, 100, 100);
            newsPageEntity.setImageUrl(fileInfo.getCompleteFilePath());
            newsPageDao.save(newsPageEntity);
        } catch (Exception exception) {

        }
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
        CategoryEntity categoryEntity = new CategoryEntity();
        userService.save(userEntity);
        return "/adminConsole";
    }


}
