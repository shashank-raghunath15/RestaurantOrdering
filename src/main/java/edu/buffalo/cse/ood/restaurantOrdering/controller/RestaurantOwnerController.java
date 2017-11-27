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
import edu.buffalo.cse.ood.restaurantOrdering.model.DrinkItem;
import edu.buffalo.cse.ood.restaurantOrdering.model.RecipeItem;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;
import edu.buffalo.cse.ood.restaurantOrdering.model.SideItem;

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
		return getRestaurantOwnerService().login(login);
	}

	@PostMapping("/")
	public RestaurantOwner addRestaurantOwner(@RequestBody RestaurantOwner restaurantOwner) {
		return getRestaurantOwnerService().addRestaurantOwner(restaurantOwner);
	}

	@PutMapping("/")
	public void updateRestaurantOwner(@RequestBody RestaurantOwner restaurantOwner) {
		getRestaurantOwnerService().updateRestaurantOwner(restaurantOwner);
	}

	@DeleteMapping("/{id}")
	public void deleteRestaurantOwner(@PathVariable Long id) {
		getRestaurantOwnerService().deleteRestaurantOwner(id);
	}

	@PostMapping("/{id}/addRecipeItem")
	public Restaurant addRecipeItemToRestaurant(@PathVariable Long id, @RequestBody RecipeItem item) {
		return getRestaurantOwnerService().addItemToRestaurant(id, item);
	}

	@PostMapping("/{id}/addSideItem")
	public Restaurant addSideItemToRestaurant(@PathVariable Long id, @RequestBody SideItem item) {
		return getRestaurantOwnerService().addItemToRestaurant(id, item);
	}

	@PostMapping("/{id}/addDrinkItem")
	public Restaurant addDrinkItemToRestaurant(@PathVariable Long id, @RequestBody DrinkItem item) {
		return getRestaurantOwnerService().addItemToRestaurant(id, item);
	}
}
