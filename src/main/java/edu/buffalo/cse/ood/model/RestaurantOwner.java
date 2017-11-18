package edu.buffalo.cse.ood.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Component
@Scope("prototype")
public class RestaurantOwner extends Person{
	@OneToOne//(mappedBy="restaurantId")
	private Restaurant restaurant; 
}
