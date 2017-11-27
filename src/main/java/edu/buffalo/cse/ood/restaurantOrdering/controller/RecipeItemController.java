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

	@PostMapping("/")
	public RecipeItem addRecipeItem(@RequestBody RecipeItem recipeItem) {
		return getRecipeItemService().addRecipeItem(recipeItem);
	}

	@PutMapping("/")
	public void updateRecipeItem(@RequestBody RecipeItem recipeItem) {
		getRecipeItemService().updateRecipeItem(recipeItem);
	}

	@DeleteMapping("/{id}")
	public void deleteRecipeItem(@PathVariable Long id) {
		getRecipeItemService().deleteRecipeItem(id);
	}
}
