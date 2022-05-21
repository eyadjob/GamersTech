package com.gamerfunthymeleaf.gamersFun.repository;


import com.gamerfunthymeleaf.gamersFun.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {

}
