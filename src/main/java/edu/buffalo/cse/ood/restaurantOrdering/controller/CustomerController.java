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

import edu.buffalo.cse.ood.restaurantOrdering.dto.Login;
import edu.buffalo.cse.ood.restaurantOrdering.model.Customer;
import edu.buffalo.cse.ood.restaurantOrdering.model.Order;

@RestController
@RequestMapping("/customer")
public class CustomerController extends Controller {

	@GetMapping("/")
	public List<Customer> getAllCustomers() {
		return getCustomerService().getAllCustomers();
	}

	/*
	 * @Requires("id != -1")
	 * 
	 * @Ensures("result.getId() == old(id), verifyCustomer(customer)")
	 */
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return getCustomerService().getCustomerById(id);
	}

	@PostMapping("/login")
	public Long login(@RequestBody Login login) {
		return getCustomerService().login(login);
	}

	@PostMapping("/")
	public Customer addCustomer(@RequestBody Customer customer) {
		return getCustomerService().addCustomer(customer);
	}

	@PutMapping("/")
	public void updateCustomer(@RequestBody Customer customer) {
		getCustomerService().updateCustomer(customer);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		getCustomerService().deleteCustomer(id);
	}

	@GetMapping("/getOrders/{id}")
	public List<Order> getOrders(@PathVariable Long id) {
		return getCustomerService().getCustomerById(id).getOrders();
	}
}
