package gamersFun.com.example.gamersFun.repository;


import gamersFun.com.example.gamersFun.entity.NewsPageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface NewsPageDao extends CrudRepository<NewsPageEntity, Long> {
    NewsPageEntity findById(int id);

}
