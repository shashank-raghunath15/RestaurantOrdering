package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.DrinkItem;
import edu.buffalo.cse.ood.restaurantOrdering.model.Item;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.service.DrinkItemService;

@Service
public class DrinkItemServiceImpl extends ServiceImpl implements DrinkItemService {

	@Override
	public List<DrinkItem> getAllDrinkItems() {
		return getDrinkItemRepository().findAll();
	}

	@Override
	public DrinkItem getDrinkItemById(Long id) {
		return getDrinkItemRepository().findOne(id);
	}

	@Override
	public DrinkItem addDrinkItem(DrinkItem drinkItem) {
		return getDrinkItemRepository().save(drinkItem);
	}

	@Override
	public void updateDrinkItem(DrinkItem drinkItem) {
		getDrinkItemRepository().save(drinkItem);
	}

	@Override
	public void deleteDrinkItem(Long id) {
		getDrinkItemRepository().delete(id);
	}

	@Override
	public List<DrinkItem> getDrinkItemsNew(Long id) {
		Restaurant restaurant = getRestaurantRepository().findOne(id);
		List<DrinkItem> allItems = getDrinkItemRepository().findAll();
		List<Long> indexList = new ArrayList<>();
		long index = 0;
		for (Item item : allItems) {
			for (Item resItem : restaurant.getAvailableItems()) {
				if (resItem.getId() == item.getId()) {
					indexList.add(index);
				}
			}
			index++;
		}
		Collections.reverse(indexList);
		for (Long ind : indexList) {
			allItems.remove(ind.intValue());
		}
		return allItems;
	}
}
