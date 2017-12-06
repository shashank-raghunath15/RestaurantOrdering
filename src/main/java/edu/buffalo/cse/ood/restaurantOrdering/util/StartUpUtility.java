package edu.buffalo.cse.ood.restaurantOrdering.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import edu.buffalo.cse.ood.restaurantOrdering.model.Admin;
import edu.buffalo.cse.ood.restaurantOrdering.model.AmountDiscountDeal;
import edu.buffalo.cse.ood.restaurantOrdering.model.Customer;
import edu.buffalo.cse.ood.restaurantOrdering.model.DrinkItem;
import edu.buffalo.cse.ood.restaurantOrdering.model.MealDiscountDeal;
import edu.buffalo.cse.ood.restaurantOrdering.model.RecipeItem;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;
import edu.buffalo.cse.ood.restaurantOrdering.model.SideItem;
import edu.buffalo.cse.ood.restaurantOrdering.service.AdminService;
import edu.buffalo.cse.ood.restaurantOrdering.service.AmountDiscountDealService;
import edu.buffalo.cse.ood.restaurantOrdering.service.CustomerService;
import edu.buffalo.cse.ood.restaurantOrdering.service.DrinkItemService;
import edu.buffalo.cse.ood.restaurantOrdering.service.ItemService;
import edu.buffalo.cse.ood.restaurantOrdering.service.MealDiscountDealService;
import edu.buffalo.cse.ood.restaurantOrdering.service.RecipeItemService;
import edu.buffalo.cse.ood.restaurantOrdering.service.RestaurantOwnerService;
import edu.buffalo.cse.ood.restaurantOrdering.service.RestaurantService;
import edu.buffalo.cse.ood.restaurantOrdering.service.SideItemService;

@Component
public class StartUpUtility {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private AdminService adminService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private RestaurantOwnerService restaurantOwnerService;

	@Autowired
	private RestaurantService restaurantService;

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

	@EventListener(classes = { ApplicationReadyEvent.class })
	public void init() {
		Admin admin = context.getBean(Admin.class);
		admin.setName("admin");
		admin.setPassword("admin");
		admin.setUsername("admin");
		admin.setAddress("admin");
		adminService.addAdmin(admin);

		Customer customer = context.getBean(Customer.class);
		customer.setName("customer");
		customer.setPassword("customer");
		customer.setUsername("customer");
		customer.setAddress("customer");
		customerService.addCustomer(customer);

		RestaurantOwner owner = context.getBean(RestaurantOwner.class);
		owner.setName("owner");
		owner.setPassword("owner");
		owner.setUsername("owner");
		owner.setAddress("owner");
		restaurantOwnerService.addRestaurantOwner(owner);

		Restaurant restaurant = context.getBean(Restaurant.class);
		restaurant.setName("restaurant");
		restaurant.setAddress("restaurant");
		restaurant.setOwner(restaurantOwnerService.getAllRestaurantOwners().get(0));
		restaurantService.addRestaurant(restaurant);

		RecipeItem recipeItem = context.getBean(RecipeItem.class);
		recipeItem.setName("RecipeItem");
		recipeItem.setPrice(10);
		recipeItem.setCalories(100);
		recipeItemService.addRecipeItem(recipeItem);

		DrinkItem drinkItem = context.getBean(DrinkItem.class);
		drinkItem.setName("DrinkItem");
		drinkItem.setPrice(10);
		drinkItem.setCalories(100);
		drinkItemService.addDrinkItem(drinkItem);

		SideItem sideItem = context.getBean(SideItem.class);
		sideItem.setName("SideItem");
		sideItem.setPrice(10);
		sideItem.setCalories(100);
		sideItemService.addSideItem(sideItem);

		restaurant = restaurantService.getAllRestaurants().get(0);
		restaurant.setAvailableItems(itemService.getAllItems());
		restaurantService.updateRestaurant(restaurant);

		AmountDiscountDeal amountDiscountDeal = context.getBean(AmountDiscountDeal.class);
		amountDiscountDeal.setRestaurant(restaurant);
		amountDiscountDeal.setEligibilityAmount(20);
		amountDiscountDeal.setDiscountAmount(3);
		amountDiscountDealService.addAmountDiscountDeal(amountDiscountDeal);

		MealDiscountDeal mealDiscountDeal = context.getBean(MealDiscountDeal.class);
		mealDiscountDeal.setRestaurant(restaurant);
		mealDiscountDeal.setDiscountAmount(5);
		mealDiscountDealService.addMealDiscountDeal(mealDiscountDeal);
	}
}
