package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.DrinkItem;

public interface DrinkItemService {

	public DrinkItem addDrinkItem(DrinkItem DrinkItem);

	public DrinkItem getDrinkItemById(Long id);

	public List<DrinkItem> getAllDrinkItems();

	public void updateDrinkItem(DrinkItem DrinkItem);

	public void deleteDrinkItem(Long id);
}
