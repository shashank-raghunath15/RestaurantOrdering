package edu.buffalo.cse.ood.restaurantOrdering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController extends edu.buffalo.cse.ood.restaurantOrdering.controller.Controller{

	@GetMapping("/")
	public ModelAndView customer(){
		return new ModelAndView("customer");
	}
}
