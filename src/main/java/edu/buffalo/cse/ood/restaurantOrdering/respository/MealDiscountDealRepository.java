package edu.buffalo.cse.ood.restaurantOrdering.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.restaurantOrdering.model.MealDiscountDeal;

public interface MealDiscountDealRepository extends JpaRepository<MealDiscountDeal, Long> {

}
