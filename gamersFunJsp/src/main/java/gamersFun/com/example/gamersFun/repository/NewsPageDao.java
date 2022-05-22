package gamersFun.com.example.gamersFun.repository;


import gamersFun.com.example.gamersFun.entity.NewsPageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsPageDao extends CrudRepository<NewsPageEntity, Long> {
    NewsPageEntity findById(int id);
}
