package gamersFun.com.example.gamersFun.repository;


import gamersFun.com.example.gamersFun.entity.CategoryEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryDao extends CrudRepository<CategoryEntity, Long> {
    CategoryEntity findByNameAfter(String name);

}
