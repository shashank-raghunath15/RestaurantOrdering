package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import edu.buffalo.cse.ood.restaurantOrdering.respository.AdminRepository;
import edu.buffalo.cse.ood.restaurantOrdering.respository.CustomerRepository;
import edu.buffalo.cse.ood.restaurantOrdering.respository.DealRepository;
import edu.buffalo.cse.ood.restaurantOrdering.respository.DrinkItemRepository;
import edu.buffalo.cse.ood.restaurantOrdering.respository.ItemRepository;
import edu.buffalo.cse.ood.restaurantOrdering.respository.OrderRepository;
import edu.buffalo.cse.ood.restaurantOrdering.respository.PersonRepository;
import edu.buffalo.cse.ood.restaurantOrdering.respository.RecipeItemRepository;
import edu.buffalo.cse.ood.restaurantOrdering.respository.RestaurantOwnerRepository;
import edu.buffalo.cse.ood.restaurantOrdering.respository.RestaurantRepository;
import edu.buffalo.cse.ood.restaurantOrdering.respository.SideItemRepository;
import lombok.Data;

@Data
public abstract class ServiceImpl {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private DealRepository dealRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestaurantOwnerRepository restaurantOwnerRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private SideItemRepository sideItemRepository;

	@Autowired
	private DrinkItemRepository drinkItemRepository;

	@Autowired
	private RecipeItemRepository recipeItemRepository;
}
