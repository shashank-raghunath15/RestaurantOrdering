package edu.buffalo.cse.ood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.buffalo.cse.ood.model.Item;
import edu.buffalo.cse.ood.model.Restaurant;
import edu.buffalo.cse.ood.model.RestaurantOwner;

@Controller
@RequestMapping("/admin")
public class AdminController extends edu.buffalo.cse.ood.controller.Controller {

	@GetMapping("/")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView("admin");
		return modelAndView;
	}
	
	@GetMapping("/addRestaurant")
	public ModelAndView addRestaurant(){
		return new ModelAndView("addRestaurant");
	}
	
	@PostMapping("/addRestaurant")
	public ModelAndView addRestaurant(Restaurant restaurant){
		getRestaurantService().addRestaurant(restaurant);
		return new ModelAndView("admin");
	}
	
	@GetMapping("/updateRestaurant")
	public ModelAndView updateRestaurant(){
		ModelAndView modelAndView = new ModelAndView("admin");
		modelAndView.addObject("restaurants", getRestaurantService().getAllRestaurants());
		return modelAndView;
	}
	
	@PostMapping("/updateRestaurant")
	public ModelAndView updateRestaurant(Restaurant restaurant){
		return null;
	}
	
	@GetMapping("/deleteRestaurant")
	public ModelAndView deleteRestaurant(){
		return null;
	}
	
	@PostMapping("/deleteRestaurant")
	public ModelAndView deleteRestaurant(Restaurant restaurant){
		return null;
	}
	
	@GetMapping("/addRestaurantOwner")
	public ModelAndView addRestaurantOwner(){
		return null;
	}
	
	@PostMapping("/addRestaurantOwner")
	public ModelAndView addRestaurantOwner(RestaurantOwner restaurantOwner){
		return null;
	}
	
	@GetMapping("/updateRestaurantOwner")
	public ModelAndView updateRestaurantOwner(){
		return null;
	}
	
	@PostMapping("/updateRestaurantOwner")
	public ModelAndView updateRestaurantOwner(RestaurantOwner restaurantOwner){
		return null;
	}
	
	@GetMapping("/deleteRestaurantOwner")
	public ModelAndView deleteRestaurantOwner(){
		return null;
	}
	
	@PostMapping("/deleteRestaurantOwner")
	public ModelAndView deleteRestaurantOwner(RestaurantOwner restaurantOwner){
		return null;
	}
	
	@GetMapping("/addItem")
	public ModelAndView addItem(){
		return null;
	}
	
	@PostMapping("/addItem")
	public ModelAndView addItem(Item item){
		return null;
	}
	
	@GetMapping("/updateItem")
	public ModelAndView updateItem(){
		return null;
	}
	
	@PostMapping("/updateItem")
	public ModelAndView updateItem(Item item){
		return null;
	}
	
	@GetMapping("/deleteItem")
	public ModelAndView deleteItem(){
		return null;
	}
	
	@PostMapping("/deleteItem")
	public ModelAndView deleteItem(Item item){
		return null;
	}
	
}
