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

import edu.buffalo.cse.ood.restaurantOrdering.model.AmountDiscountDeal;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;

@RestController
@RequestMapping("/amountDiscountDeal")
public class AmountDiscountDealController extends Controller{

	@GetMapping("/")
	public List<AmountDiscountDeal> getAllAmountDiscountDeals() {
		return getAmountDiscountDealService().getAllAmountDiscountDeals();
	}

	@GetMapping("/{id}")
	public AmountDiscountDeal getAmountDiscountDeal(@PathVariable Long id) {
		return getAmountDiscountDealService().getAmountDiscountDealById(id);
	}

	@PostMapping("/")
	public AmountDiscountDeal addAmountDiscountDeal(@RequestBody AmountDiscountDeal deal) {
		return getAmountDiscountDealService().addAmountDiscountDeal(deal);
	}
	
	@PostMapping("/restaurant/{restaurantId}")
	public Restaurant addAmountDiscountDealToRestaurant(@PathVariable Long restaurantId, @RequestBody AmountDiscountDeal deal) {
		return getAmountDiscountDealService().addAmountDiscountDealToRestaurant(restaurantId, deal);
	}

	@PutMapping("/")
	public void updateAmountDiscountDeal(@RequestBody AmountDiscountDeal deal) {
		getAmountDiscountDealService().updateAmountDiscountDeal(deal);
	}

	@DeleteMapping("/{id}")
	public void deleteAmountDiscountDeal(@PathVariable Long id) {
		getAmountDiscountDealService().deleteAmountDiscountDeal(id);
	}
}
