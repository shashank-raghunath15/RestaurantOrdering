package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.service.RestaurantService;

@Service
public class RestaurantServiceImpl extends ServiceImpl implements RestaurantService {

	@Override
	public void addRestaurant(Restaurant restaurant) {
		getRestaurantRepository().save(restaurant);
	}

	@Override
	public Restaurant getRestaurant(Long id) {
		return getRestaurantRepository().getOne(id);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		return getRestaurantRepository().findAll();
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		getRestaurantRepository().save(restaurant);
	}

	@Override
	public void deleteRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub

	}

	@Override
	public Restaurant getByOwnerId(Long id) {
		return getRestaurantRepository().findByOwnerId(id);
	}

}
