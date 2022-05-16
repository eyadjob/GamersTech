package com.appress.ravi.userRegistrationSystem.bikeSystem.controllers;


import com.appress.ravi.userRegistrationSystem.bikeSystem.models.Bike;
import com.appress.ravi.userRegistrationSystem.bikeSystem.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    @Autowired
    private BikeRepository bikeRepository;


    @GetMapping
    public List<Bike> list(){
        List<Bike> bikes =bikeRepository.findAll();

        return bikes;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike bike){
        bikeRepository.save(bike);
    }


    @GetMapping("/{id}")
    public Bike get(@PathVariable long id){
        return bikeRepository.getOne(id);
    }


}
