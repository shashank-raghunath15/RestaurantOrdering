package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.RecipeItem;
import edu.buffalo.cse.ood.restaurantOrdering.service.RecipeItemService;

@Service
public class RecipeItemServiceImpl extends ServiceImpl implements RecipeItemService {

	@Override
	public List<RecipeItem> getAllRecipeItems() {
		return getRecipeItemRepository().findAll();
	}

	@Override
	public RecipeItem getRecipeItemById(Long id) {
		return getRecipeItemRepository().getOne(id);
	}

	@Override
	public RecipeItem addRecipeItem(RecipeItem recipeItem) {
		return getRecipeItemRepository().save(recipeItem);
	}

	@Override
	public void updateRecipeItem(RecipeItem recipeItem) {
		getRecipeItemRepository().save(recipeItem);
	}

	@Override
	public void deleteRecipeItem(Long id) {
		getRecipeItemRepository().delete(id);
	}

}
