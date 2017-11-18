package edu.buffalo.cse.ood.restaurantOrdering.dto;

import edu.buffalo.cse.ood.restaurantOrdering.model.Customer;
import edu.buffalo.cse.ood.restaurantOrdering.model.Login;
import lombok.Data;

@Data
public class CustomerRegisterDto {

	private Login login;
	private Customer customer; 
}
