package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.dto.Login;
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
		return getRestaurantOwnerRepository().getOne(id);
	}

	@Override
	public void addRestaurantOwner(RestaurantOwner restaurantOwner) {
		restaurantOwner.setPassword(BCrypt.hashpw(restaurantOwner.getPassword(), BCrypt.gensalt()));
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

	@Override
	public Long login(Login login) {
		RestaurantOwner restaurantOwner = getRestaurantOwnerRepository().findByUsername(login.getUserName());
		if (restaurantOwner != null) {
			if (BCrypt.checkpw(login.getPassword(), restaurantOwner.getPassword())) {
				return restaurantOwner.getId();
			}
		}
		return -1l;
	}
}
