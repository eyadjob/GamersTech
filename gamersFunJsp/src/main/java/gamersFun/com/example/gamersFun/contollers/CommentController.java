package gamersFun.com.example.gamersFun.contollers;

import gamersFun.com.example.gamersFun.entity.Comment;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.repository.CommentsRepository;
import gamersFun.com.example.gamersFun.service.BlogsModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CommentController {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private BlogsModule blogsModule;

    @Value("${comment.added.ok}")
    private String commentAdded;

    @Value("${comment.added.failed}")
    private String failedComment;


    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<AjaxResponseStatus> addComment(ModelAndView model, @ModelAttribute("comment") @Valid Comment comment, BindingResult result, RedirectAttributes redirectAttrs, HttpServletRequest request){
        model.setViewName("app.blog");
        AjaxResponseStatus ajaxResponseStatus = null;
        if(!result.hasErrors()) {
            UserEntity user = blogsModule.getUserService().getUser(request);
            comment.setUser(user);
            String cleanComment = blogsModule.getHtmlPolicy().sanitize(comment.getText());
            comment.setText(cleanComment);
            comment.setBlog(blogsModule.getBlogsService().findById(Long.valueOf(request.getParameter("blogID"))));
            commentsRepository.save(comment);
            return new ResponseEntity(new AjaxResponseStatus(commentAdded),HttpStatus.OK);
        }

        return new ResponseEntity(ajaxResponseStatus, HttpStatus.OK);

    }
}
