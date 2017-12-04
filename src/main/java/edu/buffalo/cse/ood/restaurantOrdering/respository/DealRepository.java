package edu.buffalo.cse.ood.restaurantOrdering.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.restaurantOrdering.model.Deal;

public interface DealRepository extends JpaRepository<Deal, Long>{

	List<Deal> findByRestaurantId(long id);

}
