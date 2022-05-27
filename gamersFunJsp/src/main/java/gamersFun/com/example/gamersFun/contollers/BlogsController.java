package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.configuration.WebSecurityConfig;
import gamersFun.com.example.gamersFun.entity.Blogs;
import gamersFun.com.example.gamersFun.entity.FileInfo;
import gamersFun.com.example.gamersFun.entity.Profile;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.exception.ImageTooSmallException;
import gamersFun.com.example.gamersFun.exception.InvalidFileException;
import gamersFun.com.example.gamersFun.repository.BlogsDao;
import gamersFun.com.example.gamersFun.service.BlogsService;
import gamersFun.com.example.gamersFun.service.FileService;
import gamersFun.com.example.gamersFun.service.ProfileService;
import gamersFun.com.example.gamersFun.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.owasp.html.PolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BlogsController {

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

    @Value("${message.blogs.added}")
    private String blogsAdded;

    @Value("${photo.upload.error}")
    private String uploadImageError;

    @Value("${blogs.delete.message}")
    private String okDeleteBlogMessage;

    @Value("${blogs.delete.message}")
    private String okUpdateBlogMessage;

    @Value("${photo.upload.directoy}")
    private String photoUploadDirectory;

    @Value("${photo.upload.ok}")
    private String photoOk;
    @Value("${photo.upload.invalid}")
    private String photoInvalid;
    @Value("${photo.upload.exception}")
    private String photoIOExceptioon;
    @Value("${photo.upload.tooSmall}")
    private String photoTooSmall;


    @PostMapping("/addBlogs")
    public ModelAndView singleFileUpload(@RequestParam("file") MultipartFile file,
                                         ModelAndView modelAndView,@ModelAttribute("blog") @Valid Blogs blogs, BindingResult result) throws Exception{
        ModelAndView modelAndView1 = new ModelAndView();
        if(result.hasErrors()){
            modelAndView1.setViewName("redirect:/profile");
            return modelAndView1;
        }

        UserEntity user = userService.getUser();
        Profile profile =  profileService.getUserProfile(user);
        String cleanedBody = htmlPolicy.sanitize(blogs.getBody());
        Blogs blogs1 = new Blogs(blogs.getSubject(),cleanedBody,profile);

        try {

            FileInfo fileInfo = fileService.saveImageFile(file,System.getProperty("user.dir"),"photo","p" + user.getId(),100,100);
            blogs1.setPhotoDetails(fileInfo);
            blogsService.save(blogs1);

            profileService.save(profile);
            System.out.println(fileInfo);
        } catch (InvalidFileException e) {
            e.printStackTrace();
            blogsAdded = uploadImageError;
            //photoUploadStatus.setMessage(photoInvalid);
        } catch (IOException e) {
            e.printStackTrace();
            blogsAdded = uploadImageError;
            //photoUploadStatus.setMessage(photoIOExceptioon);
        } catch (ImageTooSmallException e) {
            e.printStackTrace();
            blogsAdded = uploadImageError;
           // photoUploadStatus.setMessage(photoTooSmall);
        }



        modelAndView1.getModel().put("blog", new Blogs());
        modelAndView1.getModel().put("blogs",blogsService.findAllByProfile(profile));

        modelAndView1.setViewName("app.profile");
        modelAndView1.getModel().put("message",blogsAdded);
        modelAndView1.getModel().put("tab","add-new-blog");
        return modelAndView1;

    }

    @RequestMapping(value = "/editBlog",method = RequestMethod.GET)
    ModelAndView getEditBlogPage(SecurityContextHolderAwareRequestWrapper requestWrapper,ModelAndView model, @RequestParam("id") Long id, @RequestParam("tab") String tab){
        model.setViewName("app.profile");
        Profile profile = getProfile();
        if(requestWrapper.isUserInRole(WebSecurityConfig.BLOGGER_ROLE)){
            model.getModel().put("blogs",blogsService.findAllByProfile(profile));
        }

        model.getModel().put("blog",blogsService.findById(id));
        model.getModel().put("tab","edit-blog");
        return model;
    }

    private Profile getProfile() {
        UserEntity user = userService.getUser();
        return profileService.getUserProfile(user);
    }

    @RequestMapping(value = "/editBlog",method = RequestMethod.POST)
    ModelAndView updateMyBlog(ModelAndView model, @RequestParam("id") Long id, @ModelAttribute("blog") Blogs blog, BindingResult result, RedirectAttributes redirectAttrs){
        model.setViewName("app.profile");
        if(!result.hasErrors()) {
            blog.setProfile(getProfile());
            blogsService.save(blog);
            redirectAttrs.addAttribute("id",blog.getId());
            redirectAttrs.addAttribute("tab","edit-blog");
            model.getModel().put("message","ok");
            model.setViewName("redirect:/editBlog");
        }

        return model;
    }

   /* @RequestMapping(value = "/deleteBlog",method = RequestMethod.GET)
    ResponseEntity<AjaxResponseStatus> deleteBlog(ModelAndView model, @RequestParam("id") Long id){
        model.setViewName("app.profile");
        Profile profile = getProfile();
        Blogs blog = blogsService.findById(id);
        blogsService.deleteBlog(blog);
        AjaxResponseStatus ajaxResponseStatus = new AjaxResponseStatus(okDeleteBlogMessage);

        return new ResponseEntity(ajaxResponseStatus, HttpStatus.OK);
    }
    */
   @RequestMapping(value = "/deleteBlog",method = RequestMethod.GET)
   ModelAndView deleteBlog(ModelAndView model, @RequestParam("id") Long id,RedirectAttributes redirectAttrs){
        model.setViewName("app.profile");
        Blogs blog = blogsService.findById(id);
        blogsService.deleteBlog(blog);
       redirectAttrs.addAttribute("id",blog.getId());
       redirectAttrs.addAttribute("tab","show-my-blogs");
       model.getModel().put("message","deleted");

       model.setViewName("redirect:/profile");
       return model;
    }
}
