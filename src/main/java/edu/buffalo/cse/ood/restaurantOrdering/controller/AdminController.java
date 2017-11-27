package edu.buffalo.cse.ood.restaurantOrdering.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.buffalo.cse.ood.restaurantOrdering.dto.Login;
import edu.buffalo.cse.ood.restaurantOrdering.model.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController extends Controller {

	@GetMapping("/")
	public List<Admin> getAllAdmins() {
		return getAdminService().getAllAdmins();
	}

	@GetMapping("/{id}")
	public Admin getAdmin(@PathVariable Long id) {
		return getAdminService().getAdminById(id);
	}

	@PostMapping("/login")
	public Long login(@RequestBody Login login) {
		return getAdminService().login(login);
	}

	@PostMapping("/")
	public Admin addAdmin(@RequestBody Admin admin) {
		return getAdminService().addAdmin(admin);
	}

	@PutMapping("/")
	public void updateAdmin(@RequestBody Admin admin) {
		getAdminService().updateAdmin(admin);
	}

	@DeleteMapping("/{id}")
	public void deleteAdmin(@PathVariable Long id) {
		getAdminService().deleteAdmin(id);
	}
}
