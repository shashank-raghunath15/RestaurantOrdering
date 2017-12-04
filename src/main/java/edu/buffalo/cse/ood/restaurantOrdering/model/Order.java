package edu.buffalo.cse.ood.restaurantOrdering.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity(name="ORDERS")
@Component
@Scope("prototype")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="restaurantId")
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name="dealId")
	private Deal deal;
	
	@ManyToMany
	private List<Item> items = new ArrayList<>();
	
	private double totalPrice;
}
