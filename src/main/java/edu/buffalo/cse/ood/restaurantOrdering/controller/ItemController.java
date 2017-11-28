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

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

import edu.buffalo.cse.ood.restaurantOrdering.model.Item;

@RestController
@RequestMapping("/item")
public class ItemController extends Controller {
	int size = 0;
	
	@GetMapping("/")
	public List<Item> getAllItems() {
		return getItemService().getAllItems();
	}

	@GetMapping("/{id}")
	public Item getItem(@PathVariable Long id) {
		return getItemService().getItemById(id);
	}

	/*@Requires("item != null")
	@Ensures({"hasItem(item)", "size = old(size)+ 1"})*/
	@PostMapping("/")
	public Item addItem(@RequestBody Item item) {
		size++;
		return getItemService().addItem(item);
	}

	private boolean hasItem(Item item) {
		List<Item> items = getAllItems();
		return items.contains(item);
	}
	
	@PutMapping("/")
	public void updateItem(@RequestBody Item item) {
		getItemService().updateItem(item);
	}
	
	/*@Requires({"id != -1", "size > 0", "hasItem(getItem(id))"})
	@Ensures({"!hasItem(item)", "size = old(size) - 1"})*/
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable Long id) {
		size--;
		getItemService().deleteItem(id);
	}
}
