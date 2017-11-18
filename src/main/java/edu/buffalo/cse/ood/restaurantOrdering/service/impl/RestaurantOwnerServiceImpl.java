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

}
