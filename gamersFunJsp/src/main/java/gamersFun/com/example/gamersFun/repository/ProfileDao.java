package gamersFun.com.example.gamersFun.repository;

import gamersFun.com.example.gamersFun.entity.Profile;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ProfileDao extends CrudRepository<Profile,Long> {
    Profile findByUser(UserEntity user);
    Page<Profile> findAllBy(String text, Pageable request);
}
