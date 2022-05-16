package com.appress.ravi.userRegistrationSystem.repository;

import com.appress.ravi.userRegistrationSystem.dto.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoJpaRepository extends JpaRepository<UserInfo,Long> {
    public UserInfo findByUsername(String name);
}
