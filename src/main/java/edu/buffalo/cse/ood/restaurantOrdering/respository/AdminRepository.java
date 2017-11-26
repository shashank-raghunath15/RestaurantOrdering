package edu.buffalo.cse.ood.restaurantOrdering.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.restaurantOrdering.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>, LoginRespository<Admin>{
}
