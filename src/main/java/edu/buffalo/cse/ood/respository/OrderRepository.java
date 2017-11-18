package edu.buffalo.cse.ood.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
