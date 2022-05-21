package gamersFun.com.example.gamersFun.service;


import gamersFun.com.example.gamersFun.entity.Bike;
import gamersFun.com.example.gamersFun.repository.BikeRepository;
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
