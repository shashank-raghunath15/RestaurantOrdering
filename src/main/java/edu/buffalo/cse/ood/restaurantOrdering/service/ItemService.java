package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.Item;

public interface ItemService {

	public void addItem(Item Item);

	public Item getItemById(Long id);

	public List<Item> getAllItems();

	public void updateItem(Item Item);

	public void deleteItem(Long id);
}
