package gamersFun.com.example.gamersFun.repository;


import gamersFun.com.example.gamersFun.entity.NewsPageEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface NewsPageDao extends PagingAndSortingRepository<NewsPageEntity, Long>, NewsPageDaoInterface {
    NewsPageEntity findById(int id);


    @Query(nativeQuery = true,value = "SHOW TABLE STATUS LIKE 'news_page'")
    Object getLatestId();

}
