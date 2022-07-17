package gamersFun.com.example.gamersFun.service;

import gamersFun.com.example.gamersFun.contollers.RegistrationContoller;
import gamersFun.com.example.gamersFun.repository.CategoryDao;
import gamersFun.com.example.gamersFun.repository.NewsPageDao;
import gamersFun.com.example.gamersFun.repository.UserDao;
import org.owasp.html.PolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlogsModule {

    public UserService getUserService() {
        return userService;
    }

    public ProfileService getProfileService() {
        return profileService;
    }

    public BlogsService getBlogsService() {
        return blogsService;
    }

    public PolicyFactory getHtmlPolicy() {
        return htmlPolicy;
    }

    public FileService getFileService() {
        return fileService;
    }

    public NewsPageDao getNewsPageDao() {
        return newsPageDao;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public RegistrationContoller getRegistrationContoller() {
        return registrationContoller;
    }

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private BlogsService blogsService;

    @Autowired
    private PolicyFactory htmlPolicy;

    @Autowired
    private FileService fileService;

    @Autowired
    private NewsPageDao newsPageDao;

    @Autowired
    private AdminService adminService;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RegistrationContoller registrationContoller;

    public EmailService getEmailService() {
        return emailService;
    }

    @Autowired
    private EmailService emailService;


}
