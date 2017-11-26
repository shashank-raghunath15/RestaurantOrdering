package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.dto.Login;
import edu.buffalo.cse.ood.restaurantOrdering.model.Admin;

public interface AdminService extends LoginService{

	public List<Admin> getAllAdmins();
	public Admin getAdminById(Long id);
	public Admin addAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public void deleteAdmin(Long id);
	public Long login(Login login);
}
