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

import edu.buffalo.cse.ood.restaurantOrdering.model.SideItem;

@RestController
@RequestMapping("/sideItem")
public class SideItemController extends Controller {

	@GetMapping("/")
	public List<SideItem> getAllSideItems() {
		return getSideItemService().getAllSideItems();
	}

	@GetMapping("/{id}")
	public SideItem getSideItem(@PathVariable Long id) {
		return getSideItemService().getSideItemById(id);
	}

	@PostMapping("/")
	public SideItem addSideItem(@RequestBody SideItem sideItem) {
		return getSideItemService().addSideItem(sideItem);
	}

	@PutMapping("/")
	public void updateSideItem(@RequestBody SideItem sideItem) {
		getSideItemService().updateSideItem(sideItem);
	}

	@DeleteMapping("/{id}")
	public void deleteSideItem(@PathVariable Long id) {
		getSideItemService().deleteSideItem(id);
	}
}
