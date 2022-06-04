package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.action.ActionEnum;
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
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
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

    @Value("${blog.photo.upload.directory}")
    private String blogImagesDirectory;

    @Value("${photo.upload.ok}")
    private String photoOk;
    @Value("${photo.upload.invalid}")
    private String photoInvalid;
    @Value("${photo.upload.exception}")
    private String photoIOExceptioon;
    @Value("${photo.upload.tooSmall}")
    private String photoTooSmall;


    @PostMapping("/addBlogs")
    public String singleFileUpload(HttpSession session, @RequestParam("file") MultipartFile file,
                                   ModelAndView modelAndView, @ModelAttribute("blog") @Valid Blogs blogs, BindingResult result) throws Exception{
        ModelAndView modelAndView1 = new ModelAndView();
        if(result.hasErrors()){
            modelAndView1.setViewName("redirect:/profile");
            modelAndView1.getModel().put("tab","add-new-blog");
            return "/profile";
        }

        UserEntity user = userService.getUser();
        Profile profile =  profileService.getUserProfile(user);
        String cleanedBody = htmlPolicy.sanitize(blogs.getBody());
        blogs.setBody(cleanedBody);
        blogs.setProfile(profile);
        String message = "";
        String error = "";
        try {
            FileInfo fileInfo = fileService.saveImageFile(file,System.getProperty("user.dir") +"/" + blogImagesDirectory + "/","photo","p" + user.getId(),100,100);
            blogs.setPhotoDetails(fileInfo);
            blogsService.save(blogs);
            profileService.save(profile);
            message=blogsAdded;
            System.out.println(fileInfo);
        } catch (InvalidFileException e) {
            e.printStackTrace();
            error=uploadImageError;
        } catch (IOException e) {
            e.printStackTrace();
            error=uploadImageError;
        } catch (ImageTooSmallException e) {
            e.printStackTrace();
            error=uploadImageError;
        }
        session.setAttribute("blogs", blogs);

        return "/profile?tab=add-new-blog&action="+ ActionEnum.ADD_BLOG + "&message=" + message + "&error=" + error;

    }

    @RequestMapping(value = "/editBlog",method = RequestMethod.GET)
    String getEditBlogPage(HttpServletRequest request,SecurityContextHolderAwareRequestWrapper requestWrapper,ModelAndView model, @RequestParam("id") Long id, @RequestParam("tab") String tab){
        model.setViewName("app.profile");
        request.setAttribute("userService",userService);
        request.setAttribute("profileService",profileService);
        request.setAttribute("blogService",blogsService);
        request.setAttribute("requestWrapper",requestWrapper);
        return "/profile?tab=edit-blog&action="+ ActionEnum.EDIT_BLOG + "&id="+id ;
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

    @RequestMapping(value = "/save-tag",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> saveInterest(@RequestParam("name") String tagName){
        UserEntity user = userService.getUser();
        Profile profile = profileService.getUserProfile(user);
        String cleanedIntrestName =  htmlPolicy.sanitize(tagName);
        /*Interest interest = interestService.createIfNotExists(cleanedIntrestName);
        profile.addInterest(interest);*/
        profileService.save(profile);

        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-tag",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> deleteInterest(@RequestParam("name") String tagName){
        UserEntity user = userService.getUser();
        Profile profile = profileService.getUserProfile(user);
       /* String cleanedIntrestName =  htmlPolicy.sanitize(interestName);
        profile.removeInterest(interestName);*/
        profileService.save(profile);

        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @RequestMapping(value = "/blogPhoto/{id}",method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<InputStreamResource> profilePhoto(@PathVariable("id") Long id, ModelAndView modelAndView) throws IOException {
        Blogs blog = blogsService.findById(id);
        Path photoPath = Paths.get(System.getProperty("user.dir"),"default","avatar.jpg");

        if(blog != null && blog.getPhoto(System.getProperty("user.dir")) != null){
            photoPath = blog.getPhoto(System.getProperty("user.dir"));
        }
        return ResponseEntity.ok().contentLength(Files.size(photoPath)).
                contentType(MediaType.parseMediaType(URLConnection.guessContentTypeFromName(photoPath.toString()))).
                body(new InputStreamResource(Files.newInputStream(photoPath, StandardOpenOption.READ)));

    }
}
