package edu.buffalo.cse.ood.restaurantOrdering.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.buffalo.cse.ood.restaurantOrdering.model.Deal;

@RestController
@RequestMapping("/deal")
public class DealController extends Controller{

	@GetMapping("/")
	public List<Deal> getAllDeals() {
		return getDealService().getAllDeals();
	}

	@GetMapping("/{id}")
	public Deal getDeal(@RequestParam(value = "id") Long id) {
		return getDealService().getDealById(id);
	}

	@PostMapping("/")
	public void addDeal(Deal deal) {
		getDealService().addDeal(deal);
	}

	@PutMapping("/")
	public void updateDeal(Deal deal) {
		getDealService().updateDeal(deal);
	}

	@DeleteMapping("/")
	public void deleteDeal(@RequestParam(value = "id") Long id) {
		getDealService().deleteDeal(id);
	}
}
