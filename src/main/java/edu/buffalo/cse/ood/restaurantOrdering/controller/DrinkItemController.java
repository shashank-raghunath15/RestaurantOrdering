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

import edu.buffalo.cse.ood.restaurantOrdering.model.DrinkItem;

@RestController
@RequestMapping("/drinkItem")
public class DrinkItemController extends Controller {

	@GetMapping("/")
	public List<DrinkItem> getAllDrinkItems() {
		return getDrinkItemService().getAllDrinkItems();
	}

	@GetMapping("/{id}")
	public DrinkItem getDrinkItem(@PathVariable Long id) {
		return getDrinkItemService().getDrinkItemById(id);
	}

	@GetMapping("/restaurant/{id}")
	public List<DrinkItem> getAllNew(@PathVariable Long id) {
		return getDrinkItemService().getDrinkItemsNew(id);
	}

	@PostMapping("/")
	public DrinkItem addDrinkItem(@RequestBody DrinkItem drinkItem) {
		return getDrinkItemService().addDrinkItem(drinkItem);
	}

	@PutMapping("/")
	public void updateDrinkItem(@RequestBody DrinkItem drinkItem) {
		getDrinkItemService().updateDrinkItem(drinkItem);
	}

	@DeleteMapping("/{id}")
	public void deleteDrinkItem(@PathVariable Long id) {
		getDrinkItemService().deleteDrinkItem(id);
	}
}
