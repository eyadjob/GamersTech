package gamersFun.com.example.gamersFun.repository;

import gamersFun.com.example.gamersFun.entity.Blogs;
import gamersFun.com.example.gamersFun.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogsDao extends PagingAndSortingRepository<Blogs,Long> {
    @Query(value = "select * from blogs blogs where blogs.profile_id =  ?1",
            nativeQuery = true)
    public Page<Blogs> findAllByProfile(Long id, Pageable pageable);
}
