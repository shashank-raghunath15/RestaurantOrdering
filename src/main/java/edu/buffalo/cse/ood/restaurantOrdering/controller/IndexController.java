package edu.buffalo.cse.ood.restaurantOrdering.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import edu.buffalo.cse.ood.restaurantOrdering.dto.CustomerRegisterDto;
import edu.buffalo.cse.ood.restaurantOrdering.model.Admin;
import edu.buffalo.cse.ood.restaurantOrdering.model.Login;
import edu.buffalo.cse.ood.restaurantOrdering.model.Person;
import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;

@Controller
public class IndexController extends edu.buffalo.cse.ood.restaurantOrdering.controller.Controller {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/login")
	public ModelAndView login(Login login, HttpSession session, RedirectAttributes attributes) {
		ModelAndView modelAndView = new ModelAndView();
		Person person = null;
		if (session.getAttribute("person") != null) {
			person = (Person) session.getAttribute("person");
		} else if (getLoginService().login(login) != null) {
			person = getLoginService().login(login);
			session.setAttribute("person", person);
		} else {
			modelAndView.setView(new RedirectView("/"));
			attributes.addFlashAttribute("msg", "Login Failed");
			return modelAndView;
		}
		if (person instanceof Admin) {
			modelAndView.setView(new RedirectView("admin/"));
		} else if (person instanceof RestaurantOwner) {
			modelAndView.setView(new RedirectView("restaurantOwner/"));
		} else {
			modelAndView.setView(new RedirectView("customer/"));
		}
		return modelAndView;
	}

	@PostMapping("/register")
	public ModelAndView register(CustomerRegisterDto customerRegisterDto) {
		ModelAndView modelAndView = new ModelAndView("index");
		Login login = customerRegisterDto.getLogin();
		login.setPerson(customerRegisterDto.getCustomer());
		getLoginService().register(login);
		return modelAndView;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
