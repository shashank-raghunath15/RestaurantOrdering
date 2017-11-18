package edu.buffalo.cse.ood.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.buffalo.cse.ood.model.Admin;
import edu.buffalo.cse.ood.model.Customer;
import edu.buffalo.cse.ood.model.Login;
import edu.buffalo.cse.ood.model.Person;
import edu.buffalo.cse.ood.model.RestaurantOwner;

@Controller
public class IndexController extends edu.buffalo.cse.ood.controller.Controller {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/login")
	public ModelAndView login(Login login, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if(session.getAttribute("person")!=null){
			Person person = (Person) session.getAttribute("person");
			if (person instanceof Admin) {
				modelAndView.setViewName("admin");
				return modelAndView;
			} else if (person instanceof RestaurantOwner) {
				modelAndView.setViewName("restaurantOwner");
				return modelAndView;
			} else {
				modelAndView.setViewName("customer");
				return modelAndView;
			}

		}
		Person person = getLoginService().login(login);
		if (person == null) {
			modelAndView.setView(new RedirectView("error"));
			return modelAndView;
		}
		if (person instanceof Admin) {
			modelAndView.setViewName("admin");
			session.setAttribute("person", person);
			return modelAndView;
		} else if (person instanceof RestaurantOwner) {
			modelAndView.setViewName("restaurantOwner");
			session.setAttribute("person", person);
			return modelAndView;
		} else {
			modelAndView.setViewName("customer");
			session.setAttribute("person", person);
			return modelAndView;
		}

	}

	@PostMapping("/register")
	public ModelAndView register(String id, String password, String name, String address) {
		ModelAndView modelAndView = new ModelAndView("index");
		Login login = getApplicationContext().getBean(Login.class);
		login.setId(id);
		login.setPassword(password);
		Customer customer = getApplicationContext().getBean(Customer.class);
		customer.setName(name);
		customer.setAddress(address);
		login.setPerson(customer);
		return modelAndView;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
