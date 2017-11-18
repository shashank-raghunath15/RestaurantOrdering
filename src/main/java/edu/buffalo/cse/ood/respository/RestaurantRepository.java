package edu.buffalo.cse.ood.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

}
