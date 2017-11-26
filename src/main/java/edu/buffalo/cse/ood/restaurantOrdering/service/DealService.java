package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.Deal;

public interface DealService {

	public Deal addDeal(Deal Deal);

	public Deal getDealById(Long id);

	public List<Deal> getAllDeals();

	public void updateDeal(Deal Deal);

	public void deleteDeal(Long id);
}
