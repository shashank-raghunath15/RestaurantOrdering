package edu.buffalo.cse.ood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController extends edu.buffalo.cse.ood.controller.Controller {

	@GetMapping("/")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView("admin");
		return modelAndView;
	}
}
