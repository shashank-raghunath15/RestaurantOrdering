package edu.buffalo.cse.ood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import edu.buffalo.cse.ood.service.AdminService;
import edu.buffalo.cse.ood.service.CustomerService;
import edu.buffalo.cse.ood.service.DealService;
import edu.buffalo.cse.ood.service.ItemService;
import edu.buffalo.cse.ood.service.LoginService;
import edu.buffalo.cse.ood.service.OrderService;
import edu.buffalo.cse.ood.service.PersonService;
import edu.buffalo.cse.ood.service.RestaurantOwnerService;
import edu.buffalo.cse.ood.service.RestaurantService;
import lombok.Data;

@Data
public abstract class Controller {

	@Autowired
	private LoginService loginService;
	
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
}
