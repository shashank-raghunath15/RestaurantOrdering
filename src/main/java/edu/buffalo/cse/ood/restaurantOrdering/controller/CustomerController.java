package edu.buffalo.cse.ood.restaurantOrdering.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.buffalo.cse.ood.restaurantOrdering.model.Customer;
import edu.buffalo.cse.ood.restaurantOrdering.model.Order;

@Controller
@RequestMapping("/customer")
public class CustomerController extends edu.buffalo.cse.ood.restaurantOrdering.controller.Controller {

	@GetMapping("/")
	public ModelAndView customer() {
		ModelAndView modelAndView = new ModelAndView("customer");
		modelAndView.addObject("restaurants", getRestaurantService().getAllRestaurants());
		return modelAndView;
	}

	@PostMapping("/order")
	public ModelAndView order(Long id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("selectItems");
		Order order = getApplicationContext().getBean(Order.class);
		Customer customer = (Customer) session.getAttribute("person");
		order.setCustomer(customer);
		order.setRestaurant(getRestaurantService().getRestaurant(id));
		modelAndView.addObject("order", order);
		return modelAndView;
	}
}
