package edu.buffalo.cse.ood.restaurantOrdering.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.restaurantOrdering.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>, LoginRespository<Customer>{

}
