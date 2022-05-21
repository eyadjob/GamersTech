package com.appress.ravi.userRegistrationSystem.bikeSystem.repositories;


import com.appress.ravi.userRegistrationSystem.bikeSystem.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BikeRepository extends JpaRepository<Bike,Long> {
}
