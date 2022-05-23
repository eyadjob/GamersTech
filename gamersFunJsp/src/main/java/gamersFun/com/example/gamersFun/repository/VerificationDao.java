package gamersFun.com.example.gamersFun.repository;

import gamersFun.com.example.gamersFun.entity.VerificationTokenEntity;
import org.springframework.data.repository.CrudRepository;

public interface VerificationDao extends CrudRepository<VerificationTokenEntity,Long> {
    VerificationTokenEntity findByToken(String token);
}
