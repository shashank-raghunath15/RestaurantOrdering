package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.Admin;

public interface AdminService {

	public List<Admin> getAllAdmins();
	public Admin getAdminById(Long id);
	public void addAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public void deleteAdmin(Long id);
}
