package gamersFun.com.example.gamersFun.repository;


import gamersFun.com.example.gamersFun.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
    User findByEmail(String email);
}
