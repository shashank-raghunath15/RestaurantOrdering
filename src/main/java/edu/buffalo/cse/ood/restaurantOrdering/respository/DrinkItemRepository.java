package edu.buffalo.cse.ood.restaurantOrdering.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.restaurantOrdering.model.DrinkItem;

public interface DrinkItemRepository extends JpaRepository<DrinkItem, Long>{

}
