package edu.buffalo.cse.ood.restaurantOrdering.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.buffalo.cse.ood.restaurantOrdering.model.Item;

@RestController
@RequestMapping("/item")
public class ItemController extends Controller{

	@GetMapping("/")
	public List<Item> getAllItems() {
		return getItemService().getAllItems();
	}

	@GetMapping("/{id}")
	public Item getItem(@RequestParam(value = "id") Long id) {
		return getItemService().getItemById(id);
	}

	@PostMapping("/")
	public void addItem(Item item) {
		getItemService().addItem(item);
	}

	@PutMapping("/")
	public void updateItem(Item item) {
		getItemService().updateItem(item);
	}

	@DeleteMapping("/")
	public void deleteItem(@RequestParam(value = "id") Long id) {
		getItemService().deleteItem(id);
	}
}
