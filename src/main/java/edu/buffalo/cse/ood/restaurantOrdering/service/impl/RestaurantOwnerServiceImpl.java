package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;
import edu.buffalo.cse.ood.restaurantOrdering.service.RestaurantOwnerService;

@Service
public class RestaurantOwnerServiceImpl extends ServiceImpl implements RestaurantOwnerService{

	@Override
	public List<RestaurantOwner> getAllRestaurantOwners() {
		return getRestaurantOwnerRepository().findAll();
	}

	@Override
	public RestaurantOwner getRestaurantOwnerById(Long id) {
		return getRestaurantOwnerRepository().getOne(id);
	}

	@Override
	public void addRestaurantOwner(RestaurantOwner restaurantOwner) {
		getRestaurantOwnerRepository().save(restaurantOwner);
	}

	@Override
	public void updateRestaurantOwner(RestaurantOwner restaurantOwner) {
		getRestaurantOwnerRepository().save(restaurantOwner);
	}

	@Override
	public void deleteRestaurantOwner(Long id) {
		getRestaurantOwnerRepository().delete(id);
	}

}
