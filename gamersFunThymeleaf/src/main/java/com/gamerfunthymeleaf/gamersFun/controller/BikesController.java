package com.gamerfunthymeleaf.gamersFun.controller;


import com.gamerfunthymeleaf.gamersFun.entity.Bike;
import com.gamerfunthymeleaf.gamersFun.repository.BikeRepository;
import com.gamerfunthymeleaf.gamersFun.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class BikesController {
	@Autowired
	private BikeService bikeService;

	@Autowired
	private BikeRepository bikeRepository;

	
	@GetMapping
	public List<Bike> list() {
		return bikeRepository.findAll();
	}

//	@PostMapping
//	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/bike", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void registerUser(@RequestBody Bike bike) {
		bikeService.addBike(bike);

	}

	@GetMapping("/{id}")
	public Bike get(@PathVariable("id") long id) {
		return bikeRepository.getById(id);
	}

	@RequestMapping(path = "/eyad", method = RequestMethod.GET)
	public String eyad(){
		return "eyad string";
	}

}
