package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.dto.Login;
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
		return getCustomerRepository().findOne(id);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		customer.setPassword(BCrypt.hashpw(customer.getPassword(), BCrypt.gensalt()));
		return getCustomerRepository().save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		getCustomerRepository().save(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		getCustomerRepository().delete(id);
	}
	
	@Override
	public Long login(Login login) {
		Customer customer = getCustomerRepository().findByUsername(login.getUsername());
		if (customer != null) {
			if (BCrypt.checkpw(login.getPassword(), customer.getPassword())) {
				return customer.getId();
			}
		}
		return -1l;
	}
}
