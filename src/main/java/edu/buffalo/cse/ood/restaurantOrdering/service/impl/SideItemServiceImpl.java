package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.model.SideItem;
import edu.buffalo.cse.ood.restaurantOrdering.service.SideItemService;

@Service
public class SideItemServiceImpl extends ServiceImpl implements SideItemService {

	@Override
	public List<SideItem> getAllSideItems() {
		return getSideItemRepository().findAll();
	}

	@Override
	public SideItem getSideItemById(Long id) {
		return getSideItemRepository().findOne(id);
	}

	@Override
	public SideItem addSideItem(SideItem sideItem) {
		return getSideItemRepository().save(sideItem);
	}

	@Override
	public void updateSideItem(SideItem sideItem) {
		getSideItemRepository().save(sideItem);
	}

	@Override
	public void deleteSideItem(Long id) {
		getSideItemRepository().delete(id);
	}

	@Override
	public List<SideItem> getSideItemsNew(Long id) {
		Restaurant restaurant = getRestaurantRepository().findOne(id);
		List<SideItem> allItems = getSideItemRepository().findAll();
		allItems.removeAll(restaurant.getAvailableItems());
		return allItems;
	}

}
