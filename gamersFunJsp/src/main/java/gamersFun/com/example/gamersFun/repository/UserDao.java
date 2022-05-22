package gamersFun.com.example.gamersFun.repository;


import gamersFun.com.example.gamersFun.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
}
