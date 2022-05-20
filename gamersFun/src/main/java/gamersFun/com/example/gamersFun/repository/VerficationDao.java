package gamersFun.com.example.gamersFun.repository;

import gamersFun.com.example.gamersFun.entity.VerficationToken;
import org.springframework.data.repository.CrudRepository;

public interface VerficationDao extends CrudRepository<VerficationToken,Long> {
    VerficationToken findByToken(String token);
}
