package edu.buffalo.cse.ood.restaurantOrdering.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

	public Restaurant findByOwnerId(Long id);
}
