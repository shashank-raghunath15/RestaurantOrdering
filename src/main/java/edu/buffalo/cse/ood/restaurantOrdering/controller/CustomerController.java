package edu.buffalo.cse.ood.restaurantOrdering.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.buffalo.cse.ood.restaurantOrdering.dto.Login;
import edu.buffalo.cse.ood.restaurantOrdering.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController extends Controller {

	@GetMapping("/")
	public List<Customer> getAllCustomers() {
		return getCustomerService().getAllCustomers();
	}

	@GetMapping("/{id}")
	public Customer getCustomer(@RequestParam(value = "id") Long id) {
		return getCustomerService().getCustomerById(id);
	}
	
	@PostMapping("/login")
	public Long login(Login login) {
		return getCustomerService().login(login);
	}

	@PostMapping("/")
	public void addCustomer(Customer customer) {
		getCustomerService().addCustomer(customer);
	}

	@PutMapping("/")
	public void updateCustomer(Customer customer) {
		getCustomerService().updateCustomer(customer);
	}

	@DeleteMapping("/")
	public void deleteCustomer(@RequestParam(value = "id") Long id) {
		getCustomerService().deleteCustomer(id);
	}
}
