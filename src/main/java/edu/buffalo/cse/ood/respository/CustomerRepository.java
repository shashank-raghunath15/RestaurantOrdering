package edu.buffalo.cse.ood.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
