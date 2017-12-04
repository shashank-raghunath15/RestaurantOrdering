package edu.buffalo.cse.ood.restaurantOrdering.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
public class Customer extends Person{

	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<Order> orders = new ArrayList<Order>();
	
	private String feedBack;
}
