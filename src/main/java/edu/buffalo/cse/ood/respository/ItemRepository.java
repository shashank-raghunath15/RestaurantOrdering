package edu.buffalo.cse.ood.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
