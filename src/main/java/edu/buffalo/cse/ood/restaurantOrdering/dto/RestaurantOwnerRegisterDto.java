package edu.buffalo.cse.ood.restaurantOrdering.dto;

import edu.buffalo.cse.ood.restaurantOrdering.model.Login;
import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;
import lombok.Data;

@Data
public class RestaurantOwnerRegisterDto {

	private Login login;
	private RestaurantOwner restaurantOwner; 
}
