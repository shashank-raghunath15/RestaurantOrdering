package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.Item;
import edu.buffalo.cse.ood.restaurantOrdering.service.ItemService;

@Service
public class ItemServiceImpl extends ServiceImpl implements ItemService {

	@Override
	public void addItem(Item item) {
		getItemRepository().save(item);
	}

	@Override
	public Item getItem(long id) {
		return getItemRepository().getOne(id);
	}

	@Override
	public List<Item> getAllItems() {
		return getItemRepository().findAll();
	}

	@Override
	public void updateItem(Item Item) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteItem(Item Item) {
		// TODO Auto-generated method stub

	}

}
