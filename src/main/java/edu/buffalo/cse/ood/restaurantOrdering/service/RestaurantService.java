package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;

public interface RestaurantService {

	public void addRestaurant(Restaurant restaurant);
	public Restaurant getRestaurant(Long id);
	public List<Restaurant> getAllRestaurants();
	public void updateRestaurant(Restaurant restaurant);
	public void deleteRestaurant(Restaurant restaurant);
	public Restaurant getByOwnerId(Long id);
}
