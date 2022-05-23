package gamersFun.com.example.gamersFun.repository;


import gamersFun.com.example.gamersFun.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends CrudRepository<CategoryEntity, Long> {
    CategoryEntity findByNameAfter(String name);
}
