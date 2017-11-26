package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.Customer;
import edu.buffalo.cse.ood.restaurantOrdering.service.CustomerService;

@Service
public class CustomerServiceImpl extends ServiceImpl implements CustomerService{
	@Override
	public List<Customer> getAllCustomers() {
		return getCustomerRepository().findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		return getCustomerRepository().getOne(id);
	}

	@Override
	public void addCustomer(Customer customer) {
		getCustomerRepository().save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		getCustomerRepository().save(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		getCustomerRepository().delete(id);
	}
}
