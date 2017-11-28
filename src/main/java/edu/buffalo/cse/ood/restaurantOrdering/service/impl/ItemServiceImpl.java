package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.Item;
import edu.buffalo.cse.ood.restaurantOrdering.service.ItemService;

@Service
public class ItemServiceImpl extends ServiceImpl implements ItemService {

	@Override
	public List<Item> getAllItems() {
		return getItemRepository().findAll();
	}

	@Override
	public Item getItemById(Long id) {
		return getItemRepository().findOne(id);
	}

	@Override
	public Item addItem(Item item) {
		return getItemRepository().save(item);
	}

	@Override
	public void updateItem(Item item) {
		getItemRepository().save(item);
	}

	@Override
	public void deleteItem(Long id) {
		getItemRepository().delete(id);
	}

}
