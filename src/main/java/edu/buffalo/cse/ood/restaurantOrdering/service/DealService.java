package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.Deal;

public interface DealService {

	public void addDeal(Deal Deal);

	public Deal getDeal(Deal Deal);

	public List<Deal> getAllDeals();

	public void updateDeal(Deal Deal);

	public void deleteDeal(Deal Deal);
}
