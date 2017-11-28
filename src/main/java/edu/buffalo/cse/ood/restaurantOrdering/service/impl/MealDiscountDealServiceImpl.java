package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.MealDiscountDeal;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.service.MealDiscountDealService;

@Service
public class MealDiscountDealServiceImpl extends ServiceImpl implements MealDiscountDealService{

	@Override
	public List<MealDiscountDeal> getAllMealDiscountDeals() {
		return getMealDiscountDealRepository().findAll();
	}

	@Override
	public MealDiscountDeal getMealDiscountDealById(Long id) {
		return getMealDiscountDealRepository().findOne(id);
	}

	@Override
	public MealDiscountDeal addMealDiscountDeal(MealDiscountDeal deal) {
		return getMealDiscountDealRepository().save(deal);
	}

	@Override
	public void updateMealDiscountDeal(MealDiscountDeal deal) {
		getMealDiscountDealRepository().save(deal);
	}

	@Override
	public void deleteMealDiscountDeal(Long id) {
		getMealDiscountDealRepository().delete(id);
	}

	@Override
	public Restaurant addMealDiscountDealToRestaurant(Long restaurantId, MealDiscountDeal deal) {
		Restaurant restaurant = getRestaurantRepository().findOne(restaurantId);
		restaurant.getAvailableDeals().add(deal);
		return getRestaurantRepository().save(restaurant);
	}

}
