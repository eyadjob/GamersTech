package gamersFun.com.example.gamersFun.service;

import gamersFun.com.example.gamersFun.entity.Blogs;
import gamersFun.com.example.gamersFun.entity.Profile;
import gamersFun.com.example.gamersFun.repository.BlogsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BlogsService {

    @Autowired
    private BlogsDao blogsDao;

    public Blogs save(Blogs blogs){
        return  blogsDao.save(blogs);
    }

    public Blogs findById(Long id){
        Optional<Blogs> blogs = blogsDao.findById(id);
        if(blogs.isPresent()){
            return blogs.get();
        }
        return null;
    }

    public Blogs findBlogByProfile(Profile profile){
        return blogsDao.findBlogByProfile(profile.getId());
    }
    public List<Blogs> findAll(){
        Iterable itr = blogsDao.findAll();
        Iterator iterator = itr.iterator();
        List<Blogs> blogs = new ArrayList<>();
        while (iterator.hasNext()){
            blogs.add((Blogs) iterator.next());
        }
        return blogs;
    }

}
