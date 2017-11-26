package edu.buffalo.cse.ood.restaurantOrdering.respository;

import edu.buffalo.cse.ood.restaurantOrdering.model.Person;

public interface LoginRespository<T extends Person> {

	public T findByUsername(String username);
}
