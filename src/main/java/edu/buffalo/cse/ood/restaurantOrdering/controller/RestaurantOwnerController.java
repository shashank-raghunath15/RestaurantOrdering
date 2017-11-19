package edu.buffalo.cse.ood.restaurantOrdering.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.buffalo.cse.ood.restaurantOrdering.model.Item;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;

@Controller
@RequestMapping("/restaurantOwner")
public class RestaurantOwnerController extends edu.buffalo.cse.ood.restaurantOrdering.controller.Controller {

	@GetMapping("/")
	public ModelAndView restaurantOwner(HttpSession session) {
		return new ModelAndView("restaurantOwner");
	}

	@GetMapping("/addItemRestaurant")
	public ModelAndView addItemRestaurant(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("addItemRestaurant");
		RestaurantOwner restaurantOwner = (RestaurantOwner) session.getAttribute("person");
		List<Item> items = getItemService().getAllItems();
		Restaurant restaurant = getRestaurantService().getByOwnerId(restaurantOwner.getId());
		items.removeAll(restaurant.getAvailableItems());
		modelAndView.addObject("items", items);
		return modelAndView;
	}

	@PostMapping("/addItemRestaurant")
	public ModelAndView addItemRestaurant(Long id, HttpSession session) {
		RestaurantOwner restaurantOwner = (RestaurantOwner) session.getAttribute("person");
		Restaurant restaurant = getRestaurantService().getByOwnerId(restaurantOwner.getId());
		restaurant.getAvailableItems().add(getItemService().getItem(id));
		getRestaurantService().updateRestaurant(restaurant);
		return new ModelAndView("restaurantOwner");
	}
}
