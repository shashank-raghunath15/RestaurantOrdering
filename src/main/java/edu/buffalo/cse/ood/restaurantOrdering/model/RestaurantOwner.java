package edu.buffalo.cse.ood.restaurantOrdering.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Component
@Scope("prototype")
public class RestaurantOwner extends Person{
	@OneToOne(mappedBy="owner")
	@JsonIgnore
	private Restaurant restaurant; 
}
