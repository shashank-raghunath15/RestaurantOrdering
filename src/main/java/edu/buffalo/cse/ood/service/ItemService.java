package edu.buffalo.cse.ood.service;

import java.util.List;

import edu.buffalo.cse.ood.model.Item;

public interface ItemService {

	public void addItem(Item Item);

	public Item getItem(Item Item);

	public List<Item> getAllItems();

	public void updateItem(Item Item);

	public void deleteItem(Item Item);
}
