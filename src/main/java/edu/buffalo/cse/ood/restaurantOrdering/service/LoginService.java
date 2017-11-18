package edu.buffalo.cse.ood.restaurantOrdering.service;

import edu.buffalo.cse.ood.restaurantOrdering.model.Login;
import edu.buffalo.cse.ood.restaurantOrdering.model.Person;

public interface LoginService {

	public Person login(Login login);
	public Login register(Login login);
}
