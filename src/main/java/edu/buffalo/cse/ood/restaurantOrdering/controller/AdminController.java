package edu.buffalo.cse.ood.restaurantOrdering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.buffalo.cse.ood.restaurantOrdering.dto.RestaurantOwnerRegisterDto;
import edu.buffalo.cse.ood.restaurantOrdering.model.DrinkItem;
import edu.buffalo.cse.ood.restaurantOrdering.model.Item;
import edu.buffalo.cse.ood.restaurantOrdering.model.Login;
import edu.buffalo.cse.ood.restaurantOrdering.model.RecipeItem;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;
import edu.buffalo.cse.ood.restaurantOrdering.model.SideItem;

@Controller
@RequestMapping("/admin")
public class AdminController extends edu.buffalo.cse.ood.restaurantOrdering.controller.Controller {

	@GetMapping("/")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView("admin");
		return modelAndView;
	}

	@GetMapping("/addRestaurant")
	public ModelAndView addRestaurant() {
		ModelAndView modelAndView = new ModelAndView("addRestaurant");
		modelAndView.addObject("restaurantOwners", getRestaurantOwnerService().getAllRestaurantOwners());
		return modelAndView;
	}

	@PostMapping("/addRestaurant")
	public ModelAndView addRestaurant(Restaurant restaurant) {
		getRestaurantService().addRestaurant(restaurant);
		return new ModelAndView("admin");
	}

	@GetMapping("/updateRestaurant")
	public ModelAndView updateRestaurant() {
		ModelAndView modelAndView = new ModelAndView("admin");
		modelAndView.addObject("restaurants", getRestaurantService().getAllRestaurants());
		return modelAndView;
	}

	@PostMapping("/updateRestaurant")
	public ModelAndView updateRestaurant(Restaurant restaurant) {
		getRestaurantService().updateRestaurant(restaurant);
		return new ModelAndView("admin");
	}

	@GetMapping("/deleteRestaurant")
	public ModelAndView deleteRestaurant() {
		return null;
	}

	@PostMapping("/deleteRestaurant")
	public ModelAndView deleteRestaurant(Restaurant restaurant) {
		return null;
	}

	@GetMapping("/addRestaurantOwner")
	public ModelAndView addRestaurantOwner() {
		return new ModelAndView("addRestaurantOwner");
	}

	@PostMapping("/addRestaurantOwner")
	public ModelAndView addRestaurantOwner(RestaurantOwnerRegisterDto restaurantOwnerRegisterDto) {
		Login login = restaurantOwnerRegisterDto.getLogin();
		login.setPerson(restaurantOwnerRegisterDto.getRestaurantOwner());
		getLoginService().register(login);
		return new ModelAndView("admin");
	}

	@GetMapping("/updateRestaurantOwner")
	public ModelAndView updateRestaurantOwner() {
		return null;
	}

	@PostMapping("/updateRestaurantOwner")
	public ModelAndView updateRestaurantOwner(RestaurantOwner restaurantOwner) {
		return null;
	}

	@GetMapping("/deleteRestaurantOwner")
	public ModelAndView deleteRestaurantOwner() {
		return null;
	}

	@PostMapping("/deleteRestaurantOwner")
	public ModelAndView deleteRestaurantOwner(RestaurantOwner restaurantOwner) {
		return null;
	}

	@GetMapping("/addItem")
	public ModelAndView addItem() {
		return new ModelAndView("addItem");
	}

	@PostMapping("/addRecipe")
	public ModelAndView addRecipe(RecipeItem recipeItem) {
		getItemService().addItem(recipeItem);
		return new ModelAndView("addItem");
	}

	@PostMapping("/addDrink")
	public ModelAndView addDrink(DrinkItem drinkItem) {
		getItemService().addItem(drinkItem);
		return new ModelAndView("addItem");
	}

	@PostMapping("/addSide")
	public ModelAndView addSide(SideItem sideItem) {
		getItemService().addItem(sideItem);
		return new ModelAndView("addItem");
	}

	@GetMapping("/updateItem")
	public ModelAndView updateItem() {
		return null;
	}

	@PostMapping("/updateItem")
	public ModelAndView updateItem(Item item) {
		return null;
	}

	@GetMapping("/deleteItem")
	public ModelAndView deleteItem() {
		return null;
	}

	@PostMapping("/deleteItem")
	public ModelAndView deleteItem(Item item) {
		return null;
	}

}
