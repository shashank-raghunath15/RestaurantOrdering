package edu.buffalo.cse.ood.restaurantOrdering.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class Login {

	private String username;
	private String password;
}
