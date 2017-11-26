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

import edu.buffalo.cse.ood.restaurantOrdering.dto.Login;
import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;

@RestController
@RequestMapping("/restaurantOwner")
public class RestaurantOwnerController extends Controller {

	@GetMapping("/")
	public List<RestaurantOwner> getAllRestaurantOwners() {
		return getRestaurantOwnerService().getAllRestaurantOwners();
	}

	@GetMapping("/{id}")
	public RestaurantOwner getRestaurantOwner(@PathVariable Long id) {
		return getRestaurantOwnerService().getRestaurantOwnerById(id);
	}

	@PostMapping("/login")
	public Long login(@RequestBody Login login) {
		return getCustomerService().login(login);
	}

	@PostMapping("/")
	public void addRestaurantOwner(@RequestBody RestaurantOwner restaurantOwner) {
		getRestaurantOwnerService().addRestaurantOwner(restaurantOwner);
	}

	@PutMapping("/")
	public void updateRestaurantOwner(@RequestBody RestaurantOwner restaurantOwner) {
		getRestaurantOwnerService().updateRestaurantOwner(restaurantOwner);
	}

	@DeleteMapping("/")
	public void deleteRestaurantOwner(@PathVariable Long id) {
		getRestaurantOwnerService().deleteRestaurantOwner(id);
	}
}
