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

import edu.buffalo.cse.ood.restaurantOrdering.model.Order;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController extends Controller {
	int size = 0;

	@GetMapping("/")
	public List<Restaurant> getAllRestaurants() {
		return getRestaurantService().getAllRestaurants();
	}

	/*
	 * @Requires("id != -1")
	 * 
	 * @Ensures({"result.getId() == old(id)","verifyAdd(restaurant)"})
	 */
	@GetMapping("/{id}")
	public Restaurant getRestaurant(@PathVariable Long id) {
		return getRestaurantService().getRestaurantById(id);
	}

	/*
	 * private boolean verifyAdd(Restaurant restaurant) { List<Restaurant>
	 * restaurantList = getAllRestaurants(); return
	 * restaurantList.contains(restaurant); }
	 */

	@GetMapping("/name/{name}")
	public Restaurant getRestaurantByName(@PathVariable String name) {
		return getRestaurantService().getRestaurantByName(name);
	}

	/*
	 * @Requires("restaurant != null")
	 * 
	 * @Ensures({"size == old(size) + 1", "verifyAdd(restaurant)"})
	 */
	@PostMapping("/")
	public Restaurant addRestaurant(@RequestBody Restaurant Restaurant) {
		size++;
		return getRestaurantService().addRestaurant(Restaurant);
	}

	@PutMapping("/")
	public void updateRestaurant(@RequestBody Restaurant Restaurant) {
		getRestaurantService().updateRestaurant(Restaurant);
	}

	@DeleteMapping("/{id}")
	public void deleteRestaurant(@PathVariable Long id) {
		size--;
		getRestaurantService().deleteRestaurant(id);
	}

	@GetMapping("/owner/{id}")
	public Restaurant getRestaurantByOwnerId(@PathVariable Long id) {
		return getRestaurantService().getByOwnerId(id);
	}

	@PostMapping("/applyDeal")
	public Order applyDeal(@RequestBody Order order) {
		return getRestaurantService().applyDeal(order);
	}
}
