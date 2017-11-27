package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.RecipeItem;

public interface RecipeItemService {

	public RecipeItem addRecipeItem(RecipeItem RecipeItem);

	public RecipeItem getRecipeItemById(Long id);

	public List<RecipeItem> getAllRecipeItems();

	public void updateRecipeItem(RecipeItem RecipeItem);

	public void deleteRecipeItem(Long id);

	public List<RecipeItem> getRecipeItemsNew(Long id);
}
