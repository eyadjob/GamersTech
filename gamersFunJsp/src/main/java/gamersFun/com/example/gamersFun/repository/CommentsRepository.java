package gamersFun.com.example.gamersFun.repository;

import gamersFun.com.example.gamersFun.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByBlog(Long blogId);
    List<Comment> findByBlogId(Long blogId);
}
