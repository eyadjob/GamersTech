package com.appress.ravi.userRegistrationSystem.repository;

import com.appress.ravi.userRegistrationSystem.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<UserDTO,Long> {
    UserDTO findByName(String name);

    List<UserDTO> findAllByNameStartsWith(String name);

}
