package gamersFun.com.example.gamersFun.repository;

import gamersFun.com.example.gamersFun.entity.Blogs;
import gamersFun.com.example.gamersFun.entity.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface BlogsDao extends CrudRepository<Blogs,Long> {

    public List<Blogs> findAllByProfile(Profile profile);
}
