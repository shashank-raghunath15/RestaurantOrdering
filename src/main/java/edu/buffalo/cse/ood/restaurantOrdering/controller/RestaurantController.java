package edu.buffalo.cse.ood.restaurantOrdering.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController extends Controller{

	@GetMapping("/")
	public List<Restaurant> getAllRestaurants() {
		return getRestaurantService().getAllRestaurants();
	}

	@GetMapping("/{id}")
	public Restaurant getRestaurant(@PathVariable Long id) {
		return getRestaurantService().getRestaurantById(id);
	}

	@GetMapping("/name/{name}")
	public Restaurant getRestaurantByName(@PathVariable String name){
		return getRestaurantService().getRestaurantByName(name);
	}
	
	@PostMapping("/")
	public Restaurant addRestaurant(@RequestBody Restaurant Restaurant) {
		return getRestaurantService().addRestaurant(Restaurant);
	}

	@PutMapping("/")
	public void updateRestaurant(@RequestBody Restaurant Restaurant) {
		getRestaurantService().updateRestaurant(Restaurant);
	}

	@DeleteMapping("/{id}")
	public void deleteRestaurant(@PathVariable Long id) {
		getRestaurantService().deleteRestaurant(id);
	}
}
