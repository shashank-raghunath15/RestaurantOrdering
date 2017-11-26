package edu.buffalo.cse.ood.restaurantOrdering.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.buffalo.cse.ood.restaurantOrdering.model.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController extends Controller {

	@GetMapping("/")
	public List<Admin> getAllAdmins() {
		return getAdminService().getAllAdmins();
	}

	@GetMapping("/{id}")
	public Admin getAdmin(@RequestParam(value = "id") Long id) {
		return getAdminService().getAdminById(id);
	}

	@PostMapping("/")
	public void addAdmin(Admin admin) {
		getAdminService().addAdmin(admin);
	}

	@PutMapping("/")
	public void updateAdmin(Admin admin) {
		getAdminService().updateAdmin(admin);
	}

	@DeleteMapping("/")
	public void deleteAdmin(@RequestParam(value = "id") Long id) {
		getAdminService().deleteAdmin(id);
	}
}
