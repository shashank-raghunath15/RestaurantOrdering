package edu.buffalo.cse.ood.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.model.Deal;

public interface DealRepository extends JpaRepository<Deal, Long>{

}
