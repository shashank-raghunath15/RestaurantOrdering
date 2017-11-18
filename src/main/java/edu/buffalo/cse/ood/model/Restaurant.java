package edu.buffalo.cse.ood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
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
@Entity
@Component
@Scope("prototype")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String address;
	@ManyToOne
	@JoinColumn(name="ownerId")
	private RestaurantOwner owner;
	@OneToMany(mappedBy="restaurant")
	private List<Deal> availableDeals = new ArrayList<Deal>();
	@OneToMany
	private List<Item> availableItems = new ArrayList<Item>();
	@ElementCollection(targetClass= Day.class)
	private List<Day> closedDays = new ArrayList<Day>();
	@OneToMany(mappedBy="restaurant")
	private List<Order> allOrders = new ArrayList<Order>();
}
