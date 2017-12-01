package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.AmountDiscountDeal;
import edu.buffalo.cse.ood.restaurantOrdering.model.Deal;
import edu.buffalo.cse.ood.restaurantOrdering.model.DrinkItem;
import edu.buffalo.cse.ood.restaurantOrdering.model.Item;
import edu.buffalo.cse.ood.restaurantOrdering.model.MealDiscountDeal;
import edu.buffalo.cse.ood.restaurantOrdering.model.Order;
import edu.buffalo.cse.ood.restaurantOrdering.model.RecipeItem;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.service.RestaurantService;

@Service
public class RestaurantServiceImpl extends ServiceImpl implements RestaurantService {
	@Override
	public List<Restaurant> getAllRestaurants() {
		return getRestaurantRepository().findAll();
	}

	@Override
	public Restaurant getRestaurantById(Long id) {
		return getRestaurantRepository().findOne(id);
	}

	@Override
	public Restaurant addRestaurant(Restaurant Restaurant) {
		return getRestaurantRepository().save(Restaurant);
	}

	@Override
	public void updateRestaurant(Restaurant Restaurant) {
		getRestaurantRepository().save(Restaurant);
	}

	@Override
	public void deleteRestaurant(Long id) {
		getRestaurantRepository().delete(id);
	}

	@Override
	public Restaurant getRestaurantByName(String name) {
		return getRestaurantRepository().findByName(name);
	}

	@Override
	public Restaurant getByOwnerId(Long id) {
		return getRestaurantRepository().findByOwnerId(id);
	}

	@Override
	public Order applyDeal(Order order) {
		Restaurant restaurant = getRestaurantRepository().getOne(order.getRestaurant().getId());
		List<Deal> deals = restaurant.getAvailableDeals();
		List<Item> items = order.getItems();
		int recipeItemCount = 0;
		int drinkItemCount = 0;
		int sideItemCount = 0;
		List<Deal> applicableDeals = new ArrayList<Deal>();

		for (Item item : items) {
			item = getItemRepository().getOne(item.getId());
			if (item instanceof RecipeItem) {
				recipeItemCount++;
			} else if (item instanceof DrinkItem) {
				drinkItemCount++;
			} else {
				sideItemCount++;
			}
		}

		for (Deal deal : deals) {
			if (deal instanceof MealDiscountDeal) {
				if (recipeItemCount > 0 && drinkItemCount > 0 && sideItemCount > 0) {
					applicableDeals.add(deal);
				}
			} else {
				AmountDiscountDeal amtDeal = (AmountDiscountDeal) deal;
				if (order.getTotalPrice() >= amtDeal.getEligibilityAmount()) {
					applicableDeals.add(deal);
				}
			}
		}
		Deal maxDiscountDeal = applicableDeals.get(0);
		for (Deal deal : applicableDeals) {
			if (maxDiscountDeal.getDiscountAmount() < deal.getDiscountAmount()) {
				maxDiscountDeal = deal;
			}
		}
		order.setDeal(maxDiscountDeal);
		return order;
	}

}
