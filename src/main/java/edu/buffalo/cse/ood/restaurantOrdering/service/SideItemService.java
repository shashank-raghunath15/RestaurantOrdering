package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.SideItem;

public interface SideItemService {

	public SideItem addSideItem(SideItem sideItem);

	public SideItem getSideItemById(Long id);

	public List<SideItem> getAllSideItems();

	public void updateSideItem(SideItem sideItem);

	public void deleteSideItem(Long id);
	
	public List<SideItem> getSideItemsNew(Long id);
}
