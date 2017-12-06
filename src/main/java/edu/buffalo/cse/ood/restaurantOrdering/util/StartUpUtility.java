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
		
		//TODO Add more objects if you want here
		Admin admin = context.getBean(Admin.class);
		admin.setName("admin");
		admin.setPassword("admin");
		admin.setUsername("admin");
		admin.setAddress("77 Heath Street, Buffalo");
		adminService.addAdmin(admin);

		Customer customer = context.getBean(Customer.class);
		customer.setName("customer");
		customer.setPassword("customer");
		customer.setUsername("customer");
		customer.setAddress("85 Montrose Avenue, Buffalo");
		customerService.addCustomer(customer);
		
		Customer customer2 = context.getBean(Customer.class);
		customer2.setName("Barack Obama");
		customer2.setPassword("obama123");
		customer2.setUsername("Barack Obama");
		customer2.setAddress("White House, DC");
		customerService.addCustomer(customer2);

		RestaurantOwner owner = context.getBean(RestaurantOwner.class);
		owner.setName("owner");
		owner.setPassword("owner");
		owner.setUsername("owner");
		owner.setAddress("90 Englewood Avenue, Buffalo");
		restaurantOwnerService.addRestaurantOwner(owner);
		
		RestaurantOwner owner2 = context.getBean(RestaurantOwner.class);
		owner2.setName("John Doe");
		owner2.setPassword("johndoe");
		owner2.setUsername("John Doe");
		owner2.setAddress("45 Niagara Falls Boulevard, Buffalo");
		restaurantOwnerService.addRestaurantOwner(owner2);

		Restaurant restaurant = context.getBean(Restaurant.class);
		restaurant.setName("Dummy Restaurant 1");
		restaurant.setAddress("35 Merrimac Street, Buffalo");
		restaurant.setOwner(restaurantOwnerService.getAllRestaurantOwners().get(0));
		restaurantService.addRestaurant(restaurant);
		
		Restaurant restaurant2 = context.getBean(Restaurant.class);
		restaurant2.setName("Dummy Restaurant 2");
		restaurant2.setAddress("58 Merrimac Street, Buffalo");
		restaurant2.setOwner(restaurantOwnerService.getAllRestaurantOwners().get(1));
		restaurantService.addRestaurant(restaurant2);

		RecipeItem recipeItem1 = context.getBean(RecipeItem.class);
		recipeItem1.setName("Hamburger");
		recipeItem1.setPrice(5.5);
		recipeItem1.setCalories(150);
		recipeItemService.addRecipeItem(recipeItem1);
		
		RecipeItem recipeItem2 = context.getBean(RecipeItem.class);
		recipeItem2.setName("Cheeseburger");
		recipeItem2.setPrice(7);
		recipeItem2.setCalories(200);
		recipeItemService.addRecipeItem(recipeItem2);

		DrinkItem drinkItem = context.getBean(DrinkItem.class);
		drinkItem.setName("Coca Cola");
		drinkItem.setPrice(3);
		drinkItem.setCalories(400);
		drinkItemService.addDrinkItem(drinkItem);


		DrinkItem drinkItem2 = context.getBean(DrinkItem.class);
		drinkItem2.setName("Lemonade");
		drinkItem2.setPrice(2.5);
		drinkItem2.setCalories(100);
		drinkItemService.addDrinkItem(drinkItem2);
		
		SideItem sideItem1 = context.getBean(SideItem.class);
		sideItem1.setName("Garlic Bread");
		sideItem1.setPrice(4);
		sideItem1.setCalories(250);
		sideItemService.addSideItem(sideItem1);
		
		SideItem sideItem2 = context.getBean(SideItem.class);
		sideItem2.setName("Chocolate Muffin");
		sideItem2.setPrice(5);
		sideItem2.setCalories(350);
		sideItemService.addSideItem(sideItem2);

		Restaurant restaurant3 = restaurantService.getAllRestaurants().get(0);
		restaurant3.setAvailableItems(itemService.getAllItems());
		restaurantService.updateRestaurant(restaurant3);
		
		Restaurant restaurant4 = restaurantService.getAllRestaurants().get(1);
		restaurant4.setAvailableItems(itemService.getAllItems());
		restaurantService.updateRestaurant(restaurant4);

		AmountDiscountDeal amountDiscountDeal = context.getBean(AmountDiscountDeal.class);
		amountDiscountDeal.setRestaurant(restaurant3);
		amountDiscountDeal.setEligibilityAmount(20);
		amountDiscountDeal.setDiscountAmount(6);
		amountDiscountDealService.addAmountDiscountDeal(amountDiscountDeal);

		MealDiscountDeal mealDiscountDeal = context.getBean(MealDiscountDeal.class);
		mealDiscountDeal.setRestaurant(restaurant3);
		mealDiscountDeal.setDiscountAmount(4);
		mealDiscountDealService.addMealDiscountDeal(mealDiscountDeal);
		
		AmountDiscountDeal amountDiscountDeal2 = context.getBean(AmountDiscountDeal.class);
		amountDiscountDeal2.setRestaurant(restaurant4);
		amountDiscountDeal2.setEligibilityAmount(15);
		amountDiscountDeal2.setDiscountAmount(3);
		amountDiscountDealService.addAmountDiscountDeal(amountDiscountDeal2);

		MealDiscountDeal mealDiscountDeal2 = context.getBean(MealDiscountDeal.class);
		mealDiscountDeal2.setRestaurant(restaurant4);
		mealDiscountDeal2.setDiscountAmount(2);
		mealDiscountDealService.addMealDiscountDeal(mealDiscountDeal2);
	}
}
