package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.AmountDiscountDeal;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.service.AmountDiscountDealService;

@Service
public class AmountDiscountDealServiceImpl extends ServiceImpl implements AmountDiscountDealService{

	@Override
	public List<AmountDiscountDeal> getAllAmountDiscountDeals() {
		return getAmountDiscountDealRepository().findAll();
	}

	@Override
	public AmountDiscountDeal getAmountDiscountDealById(Long id) {
		return getAmountDiscountDealRepository().findOne(id);
	}

	@Override
	public AmountDiscountDeal addAmountDiscountDeal(AmountDiscountDeal deal) {
		return getAmountDiscountDealRepository().save(deal);
	}

	@Override
	public void updateAmountDiscountDeal(AmountDiscountDeal deal) {
		getAmountDiscountDealRepository().save(deal);
	}

	@Override
	public void deleteAmountDiscountDeal(Long id) {
		getAmountDiscountDealRepository().delete(id);
	}
	
	@Override
	public Restaurant addAmountDiscountDealToRestaurant(Long restaurantId, AmountDiscountDeal deal) {
		Restaurant restaurant = getRestaurantRepository().findOne(restaurantId);
		deal.setRestaurant(restaurant);
		restaurant.getAvailableDeals().add(deal);
		return getRestaurantRepository().save(restaurant);
	}

}
