package edu.buffalo.cse.ood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.buffalo.cse.ood.model.Admin;
import edu.buffalo.cse.ood.model.Login;

@Controller
public class TestController extends edu.buffalo.cse.ood.controller.Controller{
	
	@GetMapping("/test")
	public String test(){
		Login login = new Login();
		login.setId("admin");
		login.setPassword("admin");
		Admin admin = new Admin();
		admin.setName("Shashank Raghunath");
		login.setPerson(admin);
		System.out.println(getLoginService().register(login));
		return "index";
	}

}
