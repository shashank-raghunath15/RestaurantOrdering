package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.dto.Login;
import edu.buffalo.cse.ood.restaurantOrdering.model.Item;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;
import edu.buffalo.cse.ood.restaurantOrdering.service.RestaurantOwnerService;

@Service
public class RestaurantOwnerServiceImpl extends ServiceImpl implements RestaurantOwnerService {

	@Override
	public List<RestaurantOwner> getAllRestaurantOwners() {
		return getRestaurantOwnerRepository().findAll();
	}

	@Override
	public RestaurantOwner getRestaurantOwnerById(Long id) {
		return getRestaurantOwnerRepository().findOne(id);
	}

	@Override
	public RestaurantOwner addRestaurantOwner(RestaurantOwner restaurantOwner) {
		restaurantOwner.setPassword(BCrypt.hashpw(restaurantOwner.getPassword(), BCrypt.gensalt()));
		return getRestaurantOwnerRepository().save(restaurantOwner);
	}

	@Override
	public void updateRestaurantOwner(RestaurantOwner restaurantOwner) {
		getRestaurantOwnerRepository().save(restaurantOwner);
	}

	@Override
	public void deleteRestaurantOwner(Long id) {
		getRestaurantOwnerRepository().delete(id);
	}

	@Override
	public Long login(Login login) {
		RestaurantOwner restaurantOwner = getRestaurantOwnerRepository().findByUsername(login.getUsername());
		if (restaurantOwner != null) {
			if (BCrypt.checkpw(login.getPassword(), restaurantOwner.getPassword())) {
				return restaurantOwner.getId();
			}
		}
		return -1l;
	}

	@Override
	public Restaurant addItemToRestaurant(Long restaurantId, Item item) {
		Restaurant restaurant = getRestaurantRepository().findOne(restaurantId);
		item = getItemRepository().findOne(item.getId());
		restaurant.getAvailableItems().add(item);
		return getRestaurantRepository().save(restaurant);
	}
}
