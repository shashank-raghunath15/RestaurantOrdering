package edu.buffalo.cse.ood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity(name="ORDERS")
@Component
@Scope("prototype")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@OneToMany
	private List<Item> items = new ArrayList<>();
	
	private double totalPrice;
}
