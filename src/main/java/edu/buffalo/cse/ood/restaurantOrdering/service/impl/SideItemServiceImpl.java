package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.SideItem;
import edu.buffalo.cse.ood.restaurantOrdering.service.SideItemService;

@Service
public class SideItemServiceImpl extends ServiceImpl implements SideItemService {

	@Override
	public List<SideItem> getAllSideItems() {
		return getSideItemRepository().findAll();
	}

	@Override
	public SideItem getSideItemById(Long id) {
		return getSideItemRepository().getOne(id);
	}

	@Override
	public SideItem addSideItem(SideItem sideItem) {
		return getSideItemRepository().save(sideItem);
	}

	@Override
	public void updateSideItem(SideItem sideItem) {
		getSideItemRepository().save(sideItem);
	}

	@Override
	public void deleteSideItem(Long id) {
		getSideItemRepository().delete(id);
	}

}
