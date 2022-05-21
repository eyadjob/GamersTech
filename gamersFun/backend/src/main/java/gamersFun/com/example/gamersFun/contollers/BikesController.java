package gamersFun.com.example.gamersFun.contollers;

import java.util.List;
import gamersFun.com.example.gamersFun.entity.Bike;
import gamersFun.com.example.gamersFun.repository.BikeRepository;
import gamersFun.com.example.gamersFun.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
//@RequestMapping("/api/v1/bikes")
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
		return bikeRepository.getOne(id);
	}


}
