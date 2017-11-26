package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.Deal;
import edu.buffalo.cse.ood.restaurantOrdering.service.DealService;

@Service
public class DealServiceImpl extends ServiceImpl implements DealService{

	@Override
	public List<Deal> getAllDeals() {
		return getDealRepository().findAll();
	}

	@Override
	public Deal getDealById(Long id) {
		return getDealRepository().getOne(id);
	}

	@Override
	public Deal addDeal(Deal deal) {
		return getDealRepository().save(deal);
	}

	@Override
	public void updateDeal(Deal deal) {
		getDealRepository().save(deal);
	}

	@Override
	public void deleteDeal(Long id) {
		getDealRepository().delete(id);
	}

}
