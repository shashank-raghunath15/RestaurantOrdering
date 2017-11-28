package edu.buffalo.cse.ood.restaurantOrdering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import edu.buffalo.cse.ood.restaurantOrdering.service.AdminService;
import edu.buffalo.cse.ood.restaurantOrdering.service.AmountDiscountDealService;
import edu.buffalo.cse.ood.restaurantOrdering.service.CustomerService;
import edu.buffalo.cse.ood.restaurantOrdering.service.DealService;
import edu.buffalo.cse.ood.restaurantOrdering.service.DrinkItemService;
import edu.buffalo.cse.ood.restaurantOrdering.service.ItemService;
import edu.buffalo.cse.ood.restaurantOrdering.service.MealDiscountDealService;
import edu.buffalo.cse.ood.restaurantOrdering.service.OrderService;
import edu.buffalo.cse.ood.restaurantOrdering.service.PersonService;
import edu.buffalo.cse.ood.restaurantOrdering.service.RecipeItemService;
import edu.buffalo.cse.ood.restaurantOrdering.service.RestaurantOwnerService;
import edu.buffalo.cse.ood.restaurantOrdering.service.RestaurantService;
import edu.buffalo.cse.ood.restaurantOrdering.service.SideItemService;
import lombok.Data;

@Data
public abstract class Controller {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DealService dealService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RestaurantOwnerService restaurantOwnerService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private SideItemService sideItemService;

	@Autowired
	private DrinkItemService drinkItemService;

	@Autowired
	private RecipeItemService recipeItemService;
	
	@Autowired
	private MealDiscountDealService mealDiscountDealService;
	
	@Autowired
	private AmountDiscountDealService amountDiscountDealService;
}
