package edu.buffalo.cse.ood.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import edu.buffalo.cse.ood.respository.AdminRepository;
import edu.buffalo.cse.ood.respository.CustomerRepository;
import edu.buffalo.cse.ood.respository.DealRepository;
import edu.buffalo.cse.ood.respository.ItemRepository;
import edu.buffalo.cse.ood.respository.LoginRepository;
import edu.buffalo.cse.ood.respository.OrderRepository;
import edu.buffalo.cse.ood.respository.PersonRepository;
import edu.buffalo.cse.ood.respository.RestaurantOwnerRepository;
import edu.buffalo.cse.ood.respository.RestaurantRepository;
import lombok.Data;

@Data
public abstract class ServiceImpl {

	@Autowired
	private LoginRepository loginRepository;
	
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
}
