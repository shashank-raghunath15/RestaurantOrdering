package edu.buffalo.cse.ood.restaurantOrdering.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
@Scope("prototype")
public class Login {

	@Id
	@Column(unique = true)
	private String id;
	private String password;
	@OneToOne(fetch= FetchType.EAGER)
	private Person person;
}
