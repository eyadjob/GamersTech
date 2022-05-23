package gamersFun.com.example.gamersFun.service;

import gamersFun.com.example.gamersFun.entity.Blogs;
import gamersFun.com.example.gamersFun.repository.BlogsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogsService {

    @Autowired
    private BlogsDao blogsDao;

    public Blogs save(Blogs blogs){
        return  blogsDao.save(blogs);
    }
}
