package gamersFun.com.example.gamersFun.repository;

import gamersFun.com.example.gamersFun.entity.VerificationToken;
import org.springframework.data.repository.CrudRepository;

public interface VerificationDao extends CrudRepository<VerificationToken,Long> {
    VerificationToken findByToken(String token);
}
