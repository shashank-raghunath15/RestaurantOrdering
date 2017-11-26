package edu.buffalo.cse.ood.restaurantOrdering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(lazyInit=true)
public class RestaurantOrderingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantOrderingApplication.class, args);
	}
}
