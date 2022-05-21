package com.gamerfunthymeleaf.gamersFun.service;


import com.gamerfunthymeleaf.gamersFun.entity.Bike;
import com.gamerfunthymeleaf.gamersFun.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public void addBike(Bike bike) {
        bikeRepository.save(bike);
    }

}
