package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.MealDiscountDeal;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;

public interface MealDiscountDealService {

	public MealDiscountDeal addMealDiscountDeal(MealDiscountDeal MealDiscountDeal);

	public MealDiscountDeal getMealDiscountDealById(Long id);

	public List<MealDiscountDeal> getAllMealDiscountDeals();

	public void updateMealDiscountDeal(MealDiscountDeal MealDiscountDeal);

	public void deleteMealDiscountDeal(Long id);
	
	public Restaurant addMealDiscountDealToRestaurant(Long restaurantId, MealDiscountDeal deal);
}
