package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.AmountDiscountDeal;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;

public interface AmountDiscountDealService {

	public AmountDiscountDeal addAmountDiscountDeal(AmountDiscountDeal AmountDiscountDeal);

	public AmountDiscountDeal getAmountDiscountDealById(Long id);

	public List<AmountDiscountDeal> getAllAmountDiscountDeals();

	public void updateAmountDiscountDeal(AmountDiscountDeal AmountDiscountDeal);

	public void deleteAmountDiscountDeal(Long id);

	public Restaurant addAmountDiscountDealToRestaurant(Long restaurantId, AmountDiscountDeal deal);
}
