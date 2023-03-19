package gamersFun.com.example.gamersFun.service;

import gamersFun.com.example.gamersFun.entity.Comment;
import gamersFun.com.example.gamersFun.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentsRepository commentsRepository;

    public List<Comment> getCommentsByBlog(Long id){
        return  commentsRepository.findByBlogId(id);
    }
}
