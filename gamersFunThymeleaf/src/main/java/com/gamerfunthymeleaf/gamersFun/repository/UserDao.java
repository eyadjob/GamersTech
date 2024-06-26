package com.gamerfunthymeleaf.gamersFun.repository;

import com.gamerfunthymeleaf.gamersFun.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
    User findByEmail(String email);
}
