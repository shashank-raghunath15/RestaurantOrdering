package edu.buffalo.cse.ood.restaurantOrdering.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.buffalo.cse.ood.restaurantOrdering.model.RecipeItem;

public interface RecipeItemRepository extends JpaRepository<RecipeItem, Long>{

}
