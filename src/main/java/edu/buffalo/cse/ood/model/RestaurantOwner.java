package edu.buffalo.cse.ood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
	@OneToMany(mappedBy="owner")
	private List<Restaurant> restaurant = new ArrayList<>(); 
}
