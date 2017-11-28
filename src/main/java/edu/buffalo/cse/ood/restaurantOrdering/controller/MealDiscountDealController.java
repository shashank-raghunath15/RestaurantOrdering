package edu.buffalo.cse.ood.restaurantOrdering.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.buffalo.cse.ood.restaurantOrdering.model.MealDiscountDeal;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;

@RestController
@RequestMapping("/mealDiscountDeal")
public class MealDiscountDealController extends Controller {

	@GetMapping("/")
	public List<MealDiscountDeal> getAllMealDiscountDeals() {
		return getMealDiscountDealService().getAllMealDiscountDeals();
	}

	@GetMapping("/{id}")
	public MealDiscountDeal getMealDiscountDeal(@PathVariable Long id) {
		return getMealDiscountDealService().getMealDiscountDealById(id);
	}

	@PostMapping("/")
	public MealDiscountDeal addMealDiscountDeal(@RequestBody MealDiscountDeal deal) {
		return getMealDiscountDealService().addMealDiscountDeal(deal);
	}

	@PutMapping("/")
	public void updateMealDiscountDeal(@RequestBody MealDiscountDeal deal) {
		getMealDiscountDealService().updateMealDiscountDeal(deal);
	}

	@PostMapping("/restaurant/{restaurantId}")
	public Restaurant addMealDiscountDealToRestaurant(@PathVariable Long restaurantId, @RequestBody MealDiscountDeal deal) {
		return getMealDiscountDealService().addMealDiscountDealToRestaurant(restaurantId, deal);
	}

	@DeleteMapping("/{id}")
	public void deleteMealDiscountDeal(@PathVariable Long id) {
		getMealDiscountDealService().deleteMealDiscountDeal(id);
	}
}
