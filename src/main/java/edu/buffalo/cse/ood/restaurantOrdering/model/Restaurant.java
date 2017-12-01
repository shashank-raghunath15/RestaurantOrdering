package edu.buffalo.cse.ood.restaurantOrdering.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Component
@Scope("prototype")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false)
	private String address;
	@OneToOne
	@JoinColumn(name = "ownerId")
	private RestaurantOwner owner;
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<Deal> availableDeals = new ArrayList<Deal>();
	@OneToMany(fetch = FetchType.EAGER)
	private List<Item> availableItems = new ArrayList<Item>();
	@ElementCollection(targetClass = Day.class)
	private List<Day> closedDays = new ArrayList<Day>();
	@OneToMany(mappedBy = "restaurant")
	@JsonIgnore
	private List<Order> allOrders = new ArrayList<Order>();
}
