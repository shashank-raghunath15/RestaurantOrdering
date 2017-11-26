package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();
	public Customer getCustomerById(Long id);
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Long id);
}
