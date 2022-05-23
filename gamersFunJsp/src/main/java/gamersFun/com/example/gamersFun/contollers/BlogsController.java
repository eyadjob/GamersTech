package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.entity.Blogs;
import gamersFun.com.example.gamersFun.entity.FileInfo;
import gamersFun.com.example.gamersFun.entity.Profile;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.exception.ImageTooSmallException;
import gamersFun.com.example.gamersFun.exception.InvalidFileException;
import gamersFun.com.example.gamersFun.repository.BlogsDao;
import gamersFun.com.example.gamersFun.service.FileService;
import gamersFun.com.example.gamersFun.service.ProfileService;
import gamersFun.com.example.gamersFun.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.owasp.html.PolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;

@Controller
public class BlogsController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private BlogsDao blogsDao;

    @Autowired
    private PolicyFactory htmlPolicy;

    @Autowired
    private FileService fileService;

    @Value("${message.blogs.added}")
    private String blogsAdded;

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
                                         ModelAndView modelAndView, Blogs blogs) {
        ModelAndView modelAndView1 = new ModelAndView();
        UserEntity user = userService.getUser();
        Profile profile =  profileService.getUserProfile(user);
        String cleanedBody = htmlPolicy.sanitize(blogs.getBody());
        Blogs blogs1 = new Blogs(blogs.getSubject(),blogs.getBody());
        blogsDao.save(blogs1);
        profile.addBlog(blogs1);



        try {
            FileInfo fileInfo = fileService.saveImageFile(file,System.getProperty("user.dir"),"photo","p" + user.getId(),100,100);
            profile.setPhotoDetails(fileInfo);
            profileService.save(profile);

            System.out.println(fileInfo);
        } catch (InvalidFileException e) {
            e.printStackTrace();
            //photoUploadStatus.setMessage(photoInvalid);
        } catch (IOException e) {
            e.printStackTrace();
            //photoUploadStatus.setMessage(photoIOExceptioon);
        } catch (ImageTooSmallException e) {
            e.printStackTrace();
           // photoUploadStatus.setMessage(photoTooSmall);
        }



        modelAndView1.getModel().put("blog", new Blogs());
        modelAndView1.setViewName("app.profile");
        modelAndView1.getModel().put("message",blogsAdded);

        return modelAndView1;

    }
}
