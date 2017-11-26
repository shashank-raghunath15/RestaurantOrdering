package edu.buffalo.cse.ood.restaurantOrdering.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Restaurant getRestaurant(@RequestParam(value = "id") Long id) {
		return getRestaurantService().getRestaurantById(id);
	}

	@PostMapping("/")
	public void addRestaurant(Restaurant Restaurant) {
		getRestaurantService().addRestaurant(Restaurant);
	}

	@PutMapping("/")
	public void updateRestaurant(Restaurant Restaurant) {
		getRestaurantService().updateRestaurant(Restaurant);
	}

	@DeleteMapping("/")
	public void deleteRestaurant(@RequestParam(value = "id") Long id) {
		getRestaurantService().deleteRestaurant(id);
	}
}
