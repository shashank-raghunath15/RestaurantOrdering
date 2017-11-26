package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;

public interface RestaurantOwnerService {
	
	public List<RestaurantOwner> getAllRestaurantOwners();
	public RestaurantOwner getRestaurantOwnerById(Long id);
	public void addRestaurantOwner(RestaurantOwner restaurantOwner);
	public void updateRestaurantOwner(RestaurantOwner restaurantOwner);
	public void deleteRestaurantOwner(Long id);
}
