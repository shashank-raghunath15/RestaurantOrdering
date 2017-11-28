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

import edu.buffalo.cse.ood.restaurantOrdering.model.RecipeItem;

@RestController
@RequestMapping("/recipeItem")
public class RecipeItemController extends Controller {
	int size = 0;
	@GetMapping("/")
	public List<RecipeItem> getAllRecipeItems() {
		return getRecipeItemService().getAllRecipeItems();
	}

	@GetMapping("/{id}")
	public RecipeItem getRecipeItem(@PathVariable Long id) {
		return getRecipeItemService().getRecipeItemById(id);
	}
	
	@GetMapping("/restaurant/{id}")
	public List<RecipeItem> getAllNew(@PathVariable Long id) {
		return getRecipeItemService().getRecipeItemsNew(id);
	}
	
	/*private boolean hasItem(RecipeItem item) {
		List<RecipeItem> items = getAllRecipeItems();
		return items.contains(item);
	}*/
	
	/*@Requires("recipeItem != null")
	@Ensures({"hasItem(recipeItem)", "size = old(size)+ 1"})*/
	@PostMapping("/")
	public RecipeItem addRecipeItem(@RequestBody RecipeItem recipeItem) {
		size++;
		return getRecipeItemService().addRecipeItem(recipeItem);
	}

	@PutMapping("/")
	public void updateRecipeItem(@RequestBody RecipeItem recipeItem) {
		getRecipeItemService().updateRecipeItem(recipeItem);
	}
	
	/*@Requires({"id != -1", "size > 0", "hasItem(getRecipeItem(id))"})
	@Ensures({"getRecipeItem(id) == null", "size = old(size) - 1"})*/
	@DeleteMapping("/{id}")
	public void deleteRecipeItem(@PathVariable Long id) {
		size--;
		getRecipeItemService().deleteRecipeItem(id);
	}
}
