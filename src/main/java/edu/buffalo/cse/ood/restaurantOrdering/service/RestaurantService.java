package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.Order;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;

public interface RestaurantService {


	public List<Restaurant> getAllRestaurants();
	public Restaurant getRestaurantById(Long id);
	public Restaurant addRestaurant(Restaurant restaurant);
	public void updateRestaurant(Restaurant restaurant);
	public void deleteRestaurant(Long id);
	public Restaurant getRestaurantByName(String name);
	public Restaurant getByOwnerId(Long id);
	public Order applyDeal(Order order);
}
