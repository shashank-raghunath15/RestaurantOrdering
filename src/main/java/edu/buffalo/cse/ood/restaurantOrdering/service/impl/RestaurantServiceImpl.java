package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.service.RestaurantService;

@Service
public class RestaurantServiceImpl extends ServiceImpl implements RestaurantService {
	@Override
	public List<Restaurant> getAllRestaurants() {
		return getRestaurantRepository().findAll();
	}

	@Override
	public Restaurant getRestaurantById(Long id) {
		return getRestaurantRepository().getOne(id);
	}

	@Override
	public Restaurant addRestaurant(Restaurant Restaurant) {
		return getRestaurantRepository().save(Restaurant);
	}

	@Override
	public void updateRestaurant(Restaurant Restaurant) {
		getRestaurantRepository().save(Restaurant);
	}

	@Override
	public void deleteRestaurant(Long id) {
		getRestaurantRepository().delete(id);
	}

	@Override
	public Restaurant getRestaurantByName(String name) {
		return getRestaurantRepository().findByName(name);
	}

	@Override
	public Restaurant getByOwnerId(Long id) {
		return getRestaurantRepository().findByOwnerId(id);
	}

}
